package top_interview_150;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IndexOfLastOccurenceInString_28 {

    public int strStr(String haystack, String needle) {
        int wordLen = needle.length();
        int n = haystack.length();
        if(n < wordLen) return -1;

        StringBuffer slidingWindow = new StringBuffer(haystack.substring(0, wordLen));
        if(needle.contentEquals(slidingWindow)) {
            return 0;
        }
        for(int i = wordLen; i < n; i++) {
            slidingWindow.deleteCharAt(0);
            slidingWindow.append(haystack.charAt(i));
            if(needle.contentEquals(slidingWindow)) {
                return i-wordLen+1;
            }
        }

        return -1;
    }

}
