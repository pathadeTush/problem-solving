import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GeneratesParantheses {

    public static List<String> generateParenthesis(int n) {
        int parathesisToBeClosedCount = 0;
        int remainingOpenParanthesis = n;
        int remainingClosedParanthesis = n;
        List<String> ans = new ArrayList<>();
        solve(n, parathesisToBeClosedCount, remainingOpenParanthesis, remainingClosedParanthesis, ans, "");

        return ans;
    }

    private static void solve(int n, int parathesisToBeClosedCount, int remainingOpenParanthesis, int remainingClosedParanthesis, List<String> ans, String sequence) {
        if(remainingClosedParanthesis == 0) {
            ans.add(sequence);
            return;
        }


        // openCount < n
        if(remainingOpenParanthesis > 0) {
            if(parathesisToBeClosedCount > 0) {
                solve(n, parathesisToBeClosedCount-1, remainingOpenParanthesis, remainingClosedParanthesis-1, ans, sequence+")");
                solve(n, parathesisToBeClosedCount+1, remainingOpenParanthesis-1, remainingClosedParanthesis, ans, sequence+"(");
            } else {
                solve(n, parathesisToBeClosedCount+1, remainingOpenParanthesis-1, remainingClosedParanthesis, ans, sequence+"(");
            }
        }
        // openCount >= n
        else {
            solve(n, parathesisToBeClosedCount-1, remainingOpenParanthesis, remainingClosedParanthesis-1, ans, sequence+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(GeneratesParantheses.generateParenthesis(4));
    }

}
