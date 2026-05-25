import java.util.ArrayList;
import java.util.List;

public class GenerateValidIp_87 {

    public static boolean isValidPart(String part) {
        if (part.isEmpty() || part.length() > 3) {
            return false;
        }

        int num = Integer.parseInt(part);
        return (num == 0 && part.length() < 2) || !part.startsWith("0") && num >= 0 && num <= 255;
    }

    public static ArrayList<String> genIp(String s) {
        int n = s.length();
        if (n < 4) {
            new ArrayList<>(List.of("-1"));
        }

        ArrayList<String> ips = new ArrayList<>();
        int beginIdxI = 0;
        for (int i = 0; i < 3 && beginIdxI + i < n; i++) {
            String part1 = s.substring(beginIdxI, beginIdxI + i + 1);
            if (!isValidPart(part1)) continue;
            int beginIdxJ = beginIdxI + i + 1;
            for (int j = 0; j < 3 && beginIdxJ + j + 1 < n; j++) {
                String part2 = s.substring(beginIdxJ, beginIdxJ + j + 1);
                if (!isValidPart(part2)) continue;
                int beginIdxK = beginIdxJ + j + 1;
                for (int k = 0; k < 3 && beginIdxK + k + 1 < n; k++) {
                    String part3 = s.substring(beginIdxK, beginIdxK + k + 1);
                    String part4 = s.substring(beginIdxK + k + 1);
                    if (!isValidPart(part3) || !isValidPart(part4)) continue;

                    ips.add(String.join(".", part1, part2, part3, part4));
                }
            }
        }

        if (ips.isEmpty()) {
            return new ArrayList<>(List.of("-1"));
        }

        return ips;
    }

    public static void main(String[] args) {
        String s = "3783022527424056";
        System.out.println(genIp(s));
    }

}
