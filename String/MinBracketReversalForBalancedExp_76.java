import java.util.Stack;

public class MinBracketReversalForBalancedExp_76 {

    public static int countRev(String exp) {
        Stack<Character> stack = new Stack<>();
        int imbalancedOpenPar = 0;
        int imbalancedClosedPar = 0;

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '{') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    imbalancedClosedPar++;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty() && imbalancedClosedPar == 0) {
            return 0;
        }

        imbalancedOpenPar = stack.size();
        if ((imbalancedOpenPar + imbalancedClosedPar) % 2 != 0) {
            return -1;
        }

        if (imbalancedClosedPar != 0) {
            int closedParBalancedByClosePar = (imbalancedClosedPar / 2);
            int closedParBalancedByOpenPar = imbalancedClosedPar - closedParBalancedByClosePar * 2;

            return closedParBalancedByClosePar + closedParBalancedByOpenPar * 2 + (imbalancedOpenPar - closedParBalancedByOpenPar) / 2;
        } else {
            return imbalancedOpenPar / 2;
        }
    }

    public static void main(String[] args) {
        String exp = "}}{{{{{}}}}{}}";
        System.out.println(countRev(exp));
    }

    /*
    }}
    2+ 2
     */

}
