import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D9P2 {
    public static class Point {
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }


        @Override
        public String toString() {
            return x + "," + y;
        }
    }

    public static class Sequence implements Comparable<Sequence>{
        Point a;
        Point b;
        long dist;

        public Sequence(Point a, Point b, long dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }


        @Override
        public String toString() {
            return b + "," + a + "," + dist;
        }

        @Override
        public int compareTo(Sequence other) {
            return Long.compare(other.dist, dist);
        }


    }
    
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("09.txt");
        ArrayList<Point> points = new ArrayList<>();
        Queue<Sequence> sQueue = new PriorityQueue<>();

        points.add(new Point(Integer.parseInt(rawInput[0].split(",")[0]), Integer.parseInt(rawInput[0].split(",")[1]), null));

        for (int i = 1; i < rawInput.length; i++) {
            points.add(new Point(Integer.parseInt(rawInput[i].split(",")[0]), Integer.parseInt(rawInput[i].split(",")[1]), points.get(points.size() - 1)));
        }

        points.get(0).parent = points.get(points.size() - 1);

        System.out.println(getHighestX(points) + ", " + getHighestY(points));

        char[][] map = buildMap(points);

        Point lastP = null;
        for (Point p : points) {
            map = findEdges(p, lastP, map);
            lastP = p;
        }

        map = findEdges(points.get(0), lastP, map);
        map = fillMap(map);


        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                sQueue.add(new Sequence(points.get(i), points.get(j), findArea(points.get(i), points.get(j))));
            }
        }

        boolean isValid = false;
        Sequence s = null;
        while (!sQueue.isEmpty() && !isValid) {
            s = sQueue.poll();
            int firstX = (s.a.x > s.b.x) ? s.b.x : s.a.x;
            int secondX = (s.a.x > s.b.x) ? s.a.x : s.b.x;
            int firstY = (s.a.y > s.b.y) ? s.b.y : s.a.y;
            int secondY = (s.a.y > s.b.y) ? s.a.y : s.b.y;


            isValid = true;
            for (int i = firstY; i < secondY; i++) {
                for (int j = firstX; j < secondX; j++) {
                    if (map[i][j] != 'X') {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    break;
                }
            }
        }

        System.out.println(s);
        
    }

    public static long findArea(Point p1, Point p2) { 
        long xDiff = Math.abs(p1.x - p2.x) + 1;
        long yDiff = Math.abs(p1.y - p2.y) + 1;

        return xDiff * yDiff;
    }

    public static int getHighestX(ArrayList<Point> points) {
        int highest = 0;
        for (Point p : points) {
            if (p.x > highest) {
                highest = p.x;
            }
        }
        return highest;
    }
    
    public static int getHighestY(ArrayList<Point> points) {
        int highest = 0;
        for (Point p : points) {
            if (p.y > highest) {
                highest = p.y;
            }
        }
        return highest;
    }


    public static char[][] buildMap(ArrayList<Point> points) {
        char[][] map = new char[getHighestY(points) + 1][getHighestX(points) + 1];
        for (char[] map1 : map) {
            for (int j = 0; j < map[0].length; j++) {
                map1[j] = '.';
            }
        }
        return map;
    }

    public static char[][] findEdges(Point p, Point lastP, char[][] map) {
        map[p.y][p.x] = 'X';
            if (lastP != null) {
                if (lastP.x == p.x) {
                    int yDiff = Math.abs(lastP.y - p.y);
                    int y = (lastP.y > p.y) ? p.y : lastP.y;
                    for (int i = 0; i < yDiff; i++) {
                        map[i + y][p.x] = 'X';
                    }
                } else {
                    int xDiff = Math.abs(lastP.x - p.x);
                    int x = (lastP.x > p.x) ? p.x : lastP.x;
                    for (int i = 0; i < xDiff; i++) {
                        map[p.y][i + x] = 'X';
                    }
                }
            }
        return map;
    }

    public static char[][] fillMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            int posOfX = -1;
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'X') {
                    posOfX = j;
                    break;
                }
            }

            if (posOfX != -1) {
                for (int j = posOfX + 1; j < map[0].length; j++) {
                    if (map[i][j] == 'X') {
                        continue;
                    }
                    map[i][j] = 'X';
                }
            }

        }
        return map;
    }
}