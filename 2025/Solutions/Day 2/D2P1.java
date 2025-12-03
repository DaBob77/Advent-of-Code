import java.io.FileNotFoundException;

public class D2P1 {
    public static void main(String[] args) throws FileNotFoundException{
        String rawInput = Filetools.txtToString("2025/Input/02.txt");
        String[] idRanges = rawInput.split(",");

        long total = 0;

        for (String idRange : idRanges) {
            long[] parts = {Long.parseLong(idRange.split("-")[0]),
                Long.parseLong(idRange.split("-")[1])};

            for (long i = parts[0]; i <= parts[0] + parts[1] - parts[0]; i++) {
                String digits = String.valueOf(i);

                if (digits.length() % 2 == 1) {
                    continue;
                }
                
                String firstHalf = digits.substring(0, digits.length() / 2);
                String secondHalf = digits.substring(digits.length() / 2, digits.length());

                if (firstHalf.equals(secondHalf)) {
                    total += Long.parseLong(firstHalf + secondHalf);
                    System.out.println(firstHalf + ", " + secondHalf);
                }
            }
        }

        System.out.println(total);
    }
}
