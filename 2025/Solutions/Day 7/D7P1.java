
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D7P1 {
    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;

            Position position = (Position) other;
            return x == position.getX() && y == position.getY(); 

        }

        @Override
        public int hashCode() {
            return Integer.parseInt("" + x + y);
        }
        
    } 

    public static void main(String[] args) throws FileNotFoundException{
        int total = 0;
        String[] input = Filetools.txtToStringArr("2025/Input/07.txt");
        Queue <Position> posQueue = new LinkedList<>();
        Position startPos = null;
        
        // Find start pos
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == 'S') {
                    startPos = new Position(j, i + 1);
                }
            }
        }

        posQueue.add(startPos);

        while (!posQueue.isEmpty()) {
            Position currentPos = posQueue.poll();
            
            if (input[currentPos.getY()].charAt(currentPos.getX()) == '^') {
                total++;
                Position rPos = new Position(currentPos.getX() + 1, currentPos.getY() + 1);
                Position lPos = new Position(currentPos.getX() - 1, currentPos.getY() + 1);

                if (!posQueue.contains(rPos)) {
                    posQueue.add(rPos);
                }
                if (!posQueue.contains(lPos)) {
                    posQueue.add(lPos);
                }
            } else {
                Position downPos = new Position(currentPos.getX(), currentPos.getY() + 1);
                if (!posQueue.contains(downPos) && downPos.getY() < input.length) {
                    posQueue.add(downPos);
                }
            }
        }

        System.out.println(total);
    }    
}
