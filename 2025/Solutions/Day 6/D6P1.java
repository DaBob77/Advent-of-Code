import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class D6P1 {
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("2025/Input/06.txt");
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        
        for (int i = 0; i < rawInput.length - 1; i++) {
            String[] parts = rawInput[i].split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < parts.length; j++) {
                if (parts[j].isBlank()) {
                    continue;
                }
                row.add(Integer.parseInt(parts[j]));
            }
            nums.add(row);
        }

        ArrayList<String> expressions = new ArrayList<>(Arrays.asList(rawInput[rawInput.length - 1].split(" ")));
        for (int i = 0; i < expressions.size(); i++){
            if (expressions.get(i).isBlank()) {
                expressions.remove(i);
                i--;
            }
        }

        long total = 0;
        for (int i = 0; i < nums.get(0).size(); i++) {
            long current = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (expressions.get(i).equals("+") || j == 0) {
                    current += nums.get(j).get(i);
                } else if (expressions.get(i).equals("*")) {
                    current *= nums.get(j).get(i);
                }
            }
            total += current;
        }

        System.out.println(total);
        
    }
}