import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D8P1 {
    public static class Pos {
        public int x;
        public int y;
        public int z;
        public Pos parent = null;
        public Pos child = null;

        public Pos(int x, int y, int z) {
            this.x =x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return String.format("")
        }

    }

    public static class Sequence implements Comparable<Sequence>{
        public Pos a;
        public Pos b;
        public double dist;

        public Sequence(Pos a, Pos b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Sequence other) {
            return Double.compare(other.dist, dist);
        }

        @Override
        public String toString() {
            return " " + a + "," + b + "," + dist;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] rawInput = Filetools.txtToStringArr("2025/Input/08.txt");
        ArrayList<Pos> poses = new ArrayList<>();
        Queue<Sequence> dists = new PriorityQueue<>();

        for (String input : rawInput) {
            String[] parts = input.split(",");
            Pos newPos = new Pos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            poses.add(newPos);
        }

        for (int i = 0; i < poses.size(); i++) {
            for (int j = i + 1; j < poses.size(); j++) {
                dists.add(new Sequence(poses.get(i), poses.get(j), findDist(poses.get(i), poses.get(j))));
            }
        }

        for (int i = 0; i <= 10; i++) {
            Sequence current = dists.poll();
            current.a.child = current.b;
            current.b.parent = current.a;
        }

        System.out.println(poses);
    }

    public static double findDist(Pos pos1, Pos pos2) {
        return Math.sqrt(Math.pow(pos2.x - pos1.x, 2) +  Math.pow(pos2.y - pos1.y, 2) + Math.pow(pos2.z - pos1.z, 2));
    }
}
