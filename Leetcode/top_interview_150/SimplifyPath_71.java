package top_interview_150;

import java.util.List;

/**
 * https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
 */
public class SimplifyPath_71 {

    public static String simplifyPath(String path) {
        String normalisedPath = normalisedPath(path);
        String[] tokens = normalisedPath.split("/");
        StringBuilder ans = new StringBuilder();
        for(String token: tokens) {
            if(token.equals(".") || token.isEmpty()) {
                continue;
            }
            if(token.equals("..")) {
                int lastIndex = ans.lastIndexOf("/");
                if(!ans.isEmpty() && lastIndex < ans.length()) {
                    ans.delete(lastIndex, ans.length());
                }
                continue;
            }
            ans.append("/");
            ans.append(token);
        }

        if(ans.isEmpty()) {
            ans.append("/");
        }
        return ans.toString();
    }

    private static String normalisedPath(String path) {
        StringBuilder normalisedPath = new StringBuilder();
        int i = 0, n = path.length();
        while (i < n) {
            char ch = path.charAt(i);
            if(ch == '/') {
                normalisedPath.append(ch);
                while (i < n && path.charAt(i) == '/') i++;
            } else {
                normalisedPath.append(ch);
                i++;
            }
        }

        return normalisedPath.toString();
    }

    public static void main(String[] args) {
//        String path = "/home//";
//        System.out.println(SimplifyPath_71.simplifyPath(path));
//        String path = "/ho/./m..e///";
//        System.out.println(SimplifyPath_71.simplifyPath(path));
//        String path = "/home/user/Documents/../Pictures";
//        System.out.println(SimplifyPath_71.simplifyPath(path));
        String path = "/n/Qz/../../ZWuLz/./R/.//";
        System.out.println(SimplifyPath_71.simplifyPath(path));
    }

}
