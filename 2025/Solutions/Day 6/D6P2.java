import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class D6P2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] rawInput = Filetools.txtToStringArr("2025/Input/06.txt");

        // Determine max width
        int maxWidth = 0;
        for (String line : rawInput) {
            if (line.length() > maxWidth) {
                maxWidth = line.length();
            }
        }
        
        // Pad lines
        char[][] grid = new char[rawInput.length][maxWidth];
        for (int i = 0; i < rawInput.length; i++) {
            String line = rawInput[i];
            for (int j = 0; j < maxWidth; j++) {
                if (j < line.length()) {
                    grid[i][j] = line.charAt(j);
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
        
        int height = rawInput.length;
        
        BigInteger grandTotal = BigInteger.ZERO;
        
        List<Integer> currentBlockCols = new ArrayList<>();
        
        for (int col = 0; col < maxWidth; col++) {
            boolean isSeparator = true;
            for (int row = 0; row < height; row++) {
                if (grid[row][col] != ' ') {
                    isSeparator = false;
                    break;
                }
            }
            
            if (isSeparator) {
                if (!currentBlockCols.isEmpty()) {
                    grandTotal = grandTotal.add(solveBlock(grid, currentBlockCols));
                    currentBlockCols.clear();
                }
            } else {
                currentBlockCols.add(col);
            }
        }
        // Process last block if exists
        if (!currentBlockCols.isEmpty()) {
            grandTotal = grandTotal.add(solveBlock(grid, currentBlockCols));
        }
        
        System.out.println(grandTotal);
    }
    
    private static BigInteger solveBlock(char[][] grid, List<Integer> cols) {
        int height = grid.length;
        char operator = ' ';
        
        // Find operator in the last row of the block
        for (int col : cols) {
            char c = grid[height - 1][col];
            if (c != ' ') {
                operator = c;
                break; 
            }
        }
        
        if (operator == ' ') {
            return BigInteger.ZERO;
        }
        
        List<BigInteger> numbers = new ArrayList<>();
        
        for (int col : cols) {
            StringBuilder sb = new StringBuilder();
            // Read digits from top to bottom, excluding the last row
            for (int row = 0; row < height - 1; row++) {
                char c = grid[row][col];
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            
            if (sb.length() > 0) {
                numbers.add(new BigInteger(sb.toString()));
            }
        }
        
        BigInteger result;
        if (operator == '+') {
            result = BigInteger.ZERO;
            for (BigInteger num : numbers) {
                result = result.add(num);
            }
        } else if (operator == '*') {
            result = BigInteger.ONE;
            for (BigInteger num : numbers) {
                result = result.multiply(num);
            }
        } else {
            return BigInteger.ZERO;
        }
        
        return result;
    }
}
