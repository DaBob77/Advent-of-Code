import java.io.FileNotFoundException;

public class D2P2 {
    public static void main(String[] args) throws FileNotFoundException{
        String rawInput = Filetools.txtToString("2025/Input/02.txt");
        String[] idRanges = rawInput.split(",");

        long total = 0;

        for (String idRange : idRanges) {
            long[] parts = {Long.parseLong(idRange.split("-")[0]),
                Long.parseLong(idRange.split("-")[1])};

            for (long i = parts[0]; i <= parts[0] + parts[1] - parts[0]; i++) {
                String digits = String.valueOf(i);

                for (int j = digits.length() / 2; j > 0; j--) {
                    if (digits.length() % j != 0) {
                        continue;
                    }

                    String pattern = digits.substring(0, j);
                    boolean valid = true;
                    for (int k = 0; k < digits.length() - pattern.length() + 1; k+= pattern.length()) {
                        if (!digits.substring(k, k + pattern.length()).equals(pattern)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        System.out.println(digits);
                        total += Long.parseLong(digits);
                        break;
                    }

                }
            }
        }

        System.out.println(total);
    }
}
