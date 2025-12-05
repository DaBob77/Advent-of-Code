import java.io.FileNotFoundException;

public class D3P1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] input = Filetools.txtToStringArr("2025/Input/03.txt");
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            String output = "";
            int highest = 0;
            int highestPos = -1;
            for (int j = 0; j < input[i].length() - 1; j++) {
                if (Character.getNumericValue(input[i].charAt(j)) > highest) {
                    highest = Character.getNumericValue(input[i].charAt(j));
                    highestPos = j;
                }
            }
            
            output += highest;
            highest = 0;
            for (int j = highestPos + 1; j < input[i].length(); j++) {
                if (Character.getNumericValue(input[i].charAt(j)) > highest) {
                    highest = Character.getNumericValue(input[i].charAt(j));
                    highestPos = j;
                }
            }
            output += highest;
            System.out.println(output);

            total += Integer.parseInt(output);
        }
        System.out.println(total);
    }
}
