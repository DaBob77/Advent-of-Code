import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filetools {
    public static String[] txtToStringArr(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        ArrayList<String> temp = new ArrayList<>();
        while (scanner.hasNext()) {
            temp.add(scanner.nextLine());
        }

        scanner.close();
        return temp.toArray(new String[0]);
    }

    public static String txtToString(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        String output = "";
        
        while (scanner.hasNext()) {
            output += scanner.nextLine();
        }

        scanner.close();
        return output;
    }
}