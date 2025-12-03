import java.io.FileNotFoundException;

public class D1P1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] input = Filetools.txtToStringArr("2025/Input/01.txt");
        
        int count = 0;
        int currentPoint = 50;
        for (String line : input) {
            int dir = line.charAt(0) == 'R' ? 1 : -1;
            int moveValue = Integer.parseInt(line.substring(1, line.length()));
            currentPoint = (currentPoint + moveValue * dir) % 100;

            System.out.println(count + ", " + line + ", " + currentPoint);

            if (currentPoint == 0) {
                count++;
            }

            //System.out.println(currentPoint);
        }
        System.out.println(count);
    }
}