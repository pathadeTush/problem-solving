public class CountAndSay_62 {

    public static String getEncoding(String str) {
        if (str.isEmpty()) {
            return str;
        }

        StringBuilder encoding = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            } else {
                encoding.append(count).append(ch);
                ch = str.charAt(i);
                count = 1;
            }
        }

        encoding.append(count).append(ch);

        return encoding.toString();
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return getEncoding(countAndSay(n-1));
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}
