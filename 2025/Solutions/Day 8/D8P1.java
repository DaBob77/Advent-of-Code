import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D8P1 {
    public static class Pos {
        public int x;
        public int y;
        public int z;

        public Pos(int x, int y, int z) {
            this.x =x;
            this.y = y;
            this.z = z;
        }


        @Override
        public String toString() {
            return String.format("X: %d, Y: %d, Z: %d.", x, y, z);
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
            return Double.compare(dist, other.dist);
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
        ArrayList<ArrayList<Pos>> circuits = new ArrayList<>();

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

        for (int i = 0; i < 1000; i++) {
            Sequence currentSequence = dists.poll();
            int indexOfA = checkForExisting(currentSequence.a, circuits);
            int indexOfB = checkForExisting(currentSequence.b, circuits);
            if (indexOfA != -1 && indexOfB != -1) {
                if (indexOfA != indexOfB) {
                    ArrayList<Pos> temp = circuits.get(indexOfB);
                    for (int j = 0; j < temp.size(); j++) {
                        circuits.get(indexOfA).add(temp.get(j));
                    }
                    circuits.remove(indexOfB);
                }

            } else if (indexOfA != -1) {
                circuits.get(indexOfA).add(currentSequence.b);
            } else if (indexOfB != -1) {
                circuits.get(indexOfB).add(currentSequence.a);
            } else {
                ArrayList<Pos> temp = new ArrayList<>();
                temp.add(currentSequence.a);
                temp.add(currentSequence.b);
                circuits.add(temp);
            }    
        }

        Collections.sort(circuits, new Comparator<ArrayList<Pos>>() {
            @Override
            public int compare(ArrayList<Pos> listA, ArrayList<Pos> listB) {
                return Integer.compare(listB.size(), listA.size());
            }
        });

        for (ArrayList<Pos> circuit : circuits) {
            System.out.println(circuit);
        }
        System.out.println("" + (circuits.get(0).size() * circuits.get(1).size() * circuits.get(2).size()));
    }

    public static double findDist(Pos pos1, Pos pos2) {
        return Math.sqrt(Math.pow(pos2.x - pos1.x, 2) +  Math.pow(pos2.y - pos1.y, 2) + Math.pow(pos2.z - pos1.z, 2));
    }

    public static int checkForExisting(Pos p, ArrayList<ArrayList<Pos>> circuits) {
        for (int i = 0; i < circuits.size(); i++) {
            if (circuits.get(i).contains(p)) {
                return i;
            }
        }
        return -1;
    }
}
