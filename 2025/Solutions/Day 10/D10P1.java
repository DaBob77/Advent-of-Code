import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class D10P1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] rawInput = Filetools.txtToStringArr("2025/Input/10.txt");
        int total = 0;

        for (String line : rawInput) {
            ArrayList<Boolean> lights = new ArrayList<>();
            int openBracket = line.indexOf('[');
            int closeBracket = line.indexOf(']');

            for (int i = openBracket + 1; i < closeBracket; i++) {
                if (line.charAt(i) == '#') {
                    lights.add(true);
                } else {
                    lights.add(false);
                }
            }
            System.out.println(lights);

            ArrayList<ArrayList<Boolean>> buttons = new ArrayList<>();
            buttons = fillList(0, buttons, lights.size());

            int endBracket = line.indexOf('{');
            int idToAddTo = 0;

    
            for (int i = closeBracket; i < endBracket - 2; i++) {
                
                if (Character.isDigit(line.charAt(i))) {
                    buttons.get(idToAddTo).set(Character.getNumericValue(line.charAt(i)), !buttons.get(idToAddTo).get(Character.getNumericValue(line.charAt(i))));
                } else if (line.charAt(i) == ')') {
                    idToAddTo++;
                    buttons = fillList(idToAddTo, buttons, lights.size());
                }
            }

            System.out.println(buttons);

        }

    }

    public static ArrayList<ArrayList<Boolean>> fillList(int index, ArrayList<ArrayList<Boolean>> list, int size) {
        list.add(new ArrayList<>());
        for (int i = 0; i < size; i++) {
            list.get(index).add(false);
        }
        return list;
    }
}
