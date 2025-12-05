import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class D5P1 {
    public static void main(String[] args) throws FileNotFoundException{
        String[] rawInput = Filetools.txtToStringArr("2025/Input/05.txt");
        List<String> ranges = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < rawInput.length; i++) {
            if (rawInput[i].contains("-")) {
                ranges.add(rawInput[i]);
            }  else if (!rawInput[i].isEmpty()){
                ids.add(rawInput[i]);
            }
        }

        List<Long> validIds = getValidIds(ranges);
        System.out.println(validIds);

        for (int i = 0; i < ids.size(); i++) {
            boolean expired = true;
            for (int j = 0; j < validIds.size(); j++) {
                if (Long.parseLong(ids.get(i)) == validIds.get(j)) {
                    expired = false;
                    break;
                }
            }

            if (!expired) {
                total++;
                System.out.println(ids.get(i));
            }
        }
        System.out.println(total);

    }
    public static List<Long> getValidIds(List<String> ranges){
        long[][] parts = new long[ranges.size()][2];

        for (int i = 0; i < ranges.size(); i++) {
            parts[i][0] = Long.parseLong(ranges.get(i).split("-")[0]);
            parts[i][1] = Long.parseLong(ranges.get(i).split("-")[1]);
        }
        
        List<Long> validIds = new ArrayList<>();

        for (int i = 0; i < parts.length; i++) {
            for (long j = parts[i][0]; j <= parts[i][1]; j++) {
                validIds.add((long)j);
            }
        }
        return validIds;
    }
    
}
