import java.io.FileNotFoundException;
import java.util.ArrayList;

public class D5P1 {
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("2025/Input/05.txt");
        ArrayList<String> ranges = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        int total = 0;

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

        for (int i = 0; i < ids.size(); i++) {
            boolean expired = true;
            for (long[] part : parts) {
                if (Long.parseLong(ids.get(i)) >= part[0] && Long.parseLong(ids.get(i)) <= part[1]) {
                    expired = false;
                    break;
                }
            }

            if (!expired) {
                total++;
                //System.out.println(ids.get(i));
            }
        }
        System.out.println(total);

    }
}
