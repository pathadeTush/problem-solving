public class RomanToDecimal_81 {

    public static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public static int romanToDecimal(String str) {
        int num = 0;
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (i + 1 < str.length()) {
                char nextCh = str.charAt(i + 1);
                if (value(ch) >= value(nextCh)) {
                    i++;
                    num += value(ch);
                } else {
                    i += 2;
                    num += value(nextCh) - value(ch);
                }
            } else {
                num += value(ch);
                i++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToDecimal("MMMCMXCIX"));
    }

}
