import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D9P1 {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
        String[] rawInput = Filetools.txtToStringArr("2025/Input/09.txt");
        ArrayList<Point> points = new ArrayList<>();
        Queue<Sequence> sQueue = new PriorityQueue<>();

        for (String line : rawInput) {
            points.add(new Point(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1])));
        }

        for (int i = 0; i < points.size(); i++) {
            for (int j = i; j < points.size(); j++) {
                sQueue.add(new Sequence(points.get(i), points.get(j), findArea(points.get(i), points.get(j))));
            }
        }

        System.out.println(sQueue.poll());
        
    }

    public static long findArea(Point p1, Point p2) { 
        long xDiff = Math.abs(p1.x - p2.x) + 1;
        long yDiff = Math.abs(p1.y - p2.y) + 1;

        return xDiff * yDiff;
    }
}