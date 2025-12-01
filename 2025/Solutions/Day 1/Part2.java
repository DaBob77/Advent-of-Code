import java.io.FileNotFoundException;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] input = Filetools.txtToStringArr("2025/Input/01.txt");
        
        int count = 0;
        int currentPoint = 50;
        for (String line : input) {
            int dir = line.charAt(0) == 'R' ? 1 : -1;
            int moveValue = Integer.parseInt(line.substring(1, line.length()));

            for (int i = 0; i < moveValue; i++) {
                currentPoint += dir;

                if (currentPoint < 0) currentPoint = 99;
                if (currentPoint > 99) currentPoint = 0;
                if (currentPoint == 0) count++;
            }
        }
        System.out.println(count);
    }
}