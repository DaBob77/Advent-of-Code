import java.io.FileNotFoundException;

public class D3P2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] input = Filetools.txtToStringArr("2025/Input/03.txt");
        long total = 0;

        for (int i = 0; i < input.length; i++) {
            String output = "";
            int lPoint = 0;
            int rPoint = input[i].length() - 11;
            
            while (output.length() < 12) {
                int highest = 0;
                for (int j = lPoint; j < rPoint; j++) {
                    if (Character.getNumericValue(input[i].charAt(j)) > highest) {
                        highest = Character.getNumericValue(input[i].charAt(j));
                        lPoint = j + 1;
                    }
                }
                output += highest;
                rPoint++;
            }
            System.out.println(output);
            total += Long.parseLong(output);
        }
        System.out.println(total);
    }
        
}
