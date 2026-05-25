public class SplitBinaryString_67 {

    public static int maxSubStr(String str) {
        int pairCount = 0;
        int count = 0;
        int n = str.length();
        int i = 0;
        while (i < n) {
            char ch = str.charAt(i);
            if(ch == '0') {
                count--;
            } else {
                count++;
            }

            if(count == 0) {
                pairCount++;
            }

            i++;
        }

        return count == 0? pairCount: -1;
    }

    public static void main(String[] args) {
        System.out.println(maxSubStr("0111100010"));
    }

}
