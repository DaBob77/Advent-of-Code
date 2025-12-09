import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("2025/Input/09.txt");
        ArrayList<Point> points = new ArrayList<>();

        for (String line : rawInput) {
            points.add(new Point(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1])));
        }

        System.out.println(points);
        System.out.println(findArea(points.get(0), points.get(1)));
        
    }

    public static long findArea(Point p1, Point p2) { 
        int xDiff = Math.abs(p1.x - p2.x);
        int yDiff = Math.abs(p1.y - p2.y);

        return xDiff * yDiff;
    }
}