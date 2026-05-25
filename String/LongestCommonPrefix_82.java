public class LongestCommonPrefix_82 {

    public static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int lcp = 0;
        StringBuilder ans = new StringBuilder();
        while (lcp < minLen) {
            char ch = strs[0].charAt(lcp);
            boolean valid = true;
            for(int i = 1; i < strs.length; i++) {
                if(ch != strs[i].charAt(lcp)) {
                    valid = false;
                    break;
                }
            }

            if(!valid) {
                break;
            }
            ans.append(ch);
            lcp++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

}
