import java.io.FileNotFoundException;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] input = Filetools.txtToStringArr("2025/Input/01.txt");
        
        for (String line : input) {
            int dir = line.charAt(0) == 'R' ? 1 : -1;
            
        }
    }
}