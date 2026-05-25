package top_interview_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/?envType=study-plan-v2&envId=top-interview-150
 */
public class TextJustification_68 {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < n) {
            List<String> lineWords = new ArrayList<>();
            int totalLength = -1;
            while (i < n && totalLength + 1 + words[i].length() <= maxWidth) {
                totalLength += 1 + words[i].length();
                lineWords.add(words[i]);
                i++;
            }
            ans.add(formLine(lineWords, totalLength, i >= n, maxWidth));
        }

        return ans;
    }

    private static String formLine(List<String> lineWords, int totalLength, boolean isLastLine, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        int wordCount = lineWords.size();
        if(wordCount == 1) {
            sb.append(lineWords.get(0));
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(" ");
            }
        }
        else if (isLastLine) {
            for (int i = 0; i < wordCount; i++) {
                String word = lineWords.get(i);
                sb.append(word);
                if (i == wordCount - 1) {
                    continue;
                }

                sb.append(" ");
            }
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(" ");
            }
        } else {
            int minSpace = (maxWidth - (totalLength - (wordCount - 1))) / (wordCount - 1);
            int extraSpace = (maxWidth - (totalLength - (wordCount - 1))) % (wordCount - 1);
            char[] minSpaceCharArr = new char[minSpace];
            Arrays.fill(minSpaceCharArr, ' ');
            String minSpaceStr = new String(minSpaceCharArr);

            for (int i = 0; i < wordCount; i++) {
                String word = lineWords.get(i);
                sb.append(word);
                if (i == wordCount - 1) {
                    continue;
                }
                sb.append(minSpaceStr);
                if (extraSpace > 0) {
                    sb.append(" ");
                    extraSpace--;
                }
            }
        }

        String word = sb.toString();
        System.out.println("lineWords" + lineWords + "  word: " + word);
        return word;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(TextJustification_68.fullJustify(words, maxWidth));
    }

}
