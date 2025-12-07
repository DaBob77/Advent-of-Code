import java.io.FileNotFoundException;
import java.util.ArrayList;

public class D5P2 {
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("2025/Input/05.txt");
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        long total = 0;

        for (String rawInput1 : rawInput) {
            if (rawInput1.contains("-")) {
                ranges.add(rawInput1);
            } else if (!rawInput1.isEmpty()) {
                ids.add(rawInput1);
            }
            System.out.println(ranges);
        }

        long[][] parts = new long[ranges.size()][2];

        for (int i = 0; i < ranges.size(); i++) {
            parts[i][0] = Long.parseLong(ranges.get(i).split("-")[0]);
            parts[i][1] = Long.parseLong(ranges.get(i).split("-")[1]);
        }

        parts = bubbleSort(parts);
        
        boolean hasChange = true;
        
        /*
        Cases:
        2-5, 3-6 - after, after - good
        2-5, 2-5 - same, same - good
        2-5, 3-5 - afer, same - good
        2-5, 2-6 - same, after - good
        2-5, 1-4 - before, before - good
        2-5, 2-4 - same, before - good
        2-5, 1-5 - before, same - good
        2-5, 1-6 - before, after - good
        2-5, 3-4 - after, before - good
        */

        //2,107,608,268
        //2107608282
        //2107608268
        //357,674,099,117,260


        while (hasChange) {
            parts = bubbleSort(parts);
            hasChange = false;
            for (int i = 0; i < parts.length; i++) {
                for (int j = 0; j < parts.length; j++) {
                    if (parts[j][0] == 0 && parts[j][1] == 0 || parts[i] == parts[j]) {
                        continue;
                    }
                    if (parts[i][0] <= parts[j][0] && parts[i][1] >= parts[j][1]) {
                        parts[j][0] = 0;
                        parts[j][1] = 0;
                        hasChange = true;
                    }
                }
            }

            for (int i = 0; i < parts.length - 1; i++) {
                if (parts[i][0] == 0|| (parts[i + 1][0] == 0)) {
                    continue;
                }
                if (parts[i][1] >= parts[i + 1][0]) {
                    parts[i + 1][0] = parts[i][1] + 1;
                    hasChange = true;
                }
            }

            
        }
        
        
        for (long[] row : parts) {
            for (long item : row) {
                System.out.print(item + "-");
            }
            total += row[1] - row[0];
            if (!(row[0] == 0 && row[1] == 0)) {
                total++;
            }
            System.out.println();
        }

        System.out.println(total);
    }

    public static long[][] bubbleSort(long[][] arr) {
        boolean hadChange = true;
        long[][] sortedArr = arr;

        while (hadChange) {
            hadChange = false;
            for (int i = 0; i < sortedArr.length - 1; i++) {
                if (sortedArr[i][0] > sortedArr[i + 1][0]) {
                    long[] temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    hadChange = true;
                }
            }
        }
        return sortedArr;
    }
}