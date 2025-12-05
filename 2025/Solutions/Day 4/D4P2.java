import java.io.FileNotFoundException;

public class D4P2 {
    public static void main(String[] args) throws FileNotFoundException{
        boolean hasChange = true;
        char[][] input = Filetools.txtToCharArr("2025/Input/04.txt");
        int[][] nearbyCount = new int[input.length][input[0].length];

        int[][] dirs = {{1, -1}, {1, 0}, {1, 1},
                {0, -1}, {0, 1}, 
                {-1, -1}, {-1, 0}, {-1, 1}};

        long total = 0;

        for (int i = 0; i < nearbyCount.length; i++) {
            for (int j = 0; j < nearbyCount[0].length; j++) {
                nearbyCount[i][j] = -1;
            }
        }
                
        while(hasChange) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j] == '@') {
                        nearbyCount[i][j] = 0;
                        for (int[] dir : dirs) {
                            if (0 > i + dir[0] || i + dir[0] > input[0].length - 1 || 0 > j + dir[1] || j + dir[1] > input[0].length - 1) {
                                continue;
                            }
                            if (input[i + dir[0]][j + dir[1]] == '@') {
                                nearbyCount[i][j]++;
                            }
                        }
                    }
                }
            }
                    
            hasChange = false;
            for (int i = 0; i < nearbyCount.length; i++) {
                for (int j = 0; j < nearbyCount[0].length; j++) {
                    if (nearbyCount[i][j] < 4 && nearbyCount[i][j] != -1) {
                        input[i][j] = '.';
                        total++;
                        hasChange = true;
                    }
                    System.out.print(input[i][j]);
                    nearbyCount[i][j] = -1;
                }
                System.out.println();
            }
            System.out.println(total);    
        }
    }  
}