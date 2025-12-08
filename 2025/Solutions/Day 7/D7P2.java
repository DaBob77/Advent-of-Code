
import java.io.FileNotFoundException;
import java.lang.classfile.Label;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class D7P2 {
    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;

            Position position = (Position) other;
            return x == position.x && y == position.y;

        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
    } 

    

    public static void main(String[] args) throws FileNotFoundException{
        String[] input = Filetools.txtToStringArr("2025/Input/07.txt");
        Map<Position, Long> cache = new HashMap<>();
        Position startPos = null;
        
        // Find start pos
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == 'S') {
                    startPos = new Position(j, i + 1);
                }
            }
        }

        System.out.println(countPaths(startPos, input, cache));

    }

    public static long countPaths(Position pos, String[] grid, Map<Position, Long> cache) {
        if (pos.y >= grid.length) {
            return 1;
        }
        
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }

        long paths = 0;
        char tile = grid[pos.y].charAt(pos.x);

        if (tile == '^') {
            Position rPos = new Position(pos.x + 1, pos.y + 1);
            paths += countPaths(rPos, grid, cache);
            Position lPos = new Position(pos.x - 1, pos.y + 1);
            paths += countPaths(lPos, grid, cache);
        } else {
            Position downPos = new Position(pos.x, pos.y + 1);
            paths += countPaths(downPos, grid, cache);
        }

        cache.put(pos, paths);
        return paths;

    }
}
