public class MinSwapsForBracketBalanc_85 {

    /*
        []]]][[[]][[[[]]
        // starting from left
        [][]]][[]][[[[]] 3
        [][][]][]][[[[]] 2
        [][][][]]][[[[]] 1
        [][][][][]][[[]] 2
        [][][][][][][[]] 1
        total = 9

        // starting from right
        []]]][[[][[][[]] 2
        []]]][[[[][][[]] 1
        []]][[[][][][[]] 3
        []][[][][][][[]] 2
        [][][][][][][[]] 1
        total = 9


        []]]][[][][[[[]]
        // starting from left
        [][]]][][][[[[]] 3
        [][][]]][][[[[]] 2
        [][][][]]][[[[]] 2
        [][][][][]][[[]] 2
        [][][][][][][[]] 1
        total = 10

        // starting from right
        []]]][[][[[][[]] 2
        []]]][[[[][][[]] 2
        []]][[[][][][[]] 3
        []][[][][][][[]] 2
        [][][][][][][[]] 1
        total = 10



        []]]][[][][[[[ ]]
        close = 2
        open = 2
        0 + 2 + 2 + 2 + 2 + 0 + 2 + 0
         */
    static int minimumNumberOfSwaps(String string) {
        int len = string.length();
        if (string.isEmpty()) {
            return 0;
        }
        if (len % 2 != 0) {
            return -1;
        }

        int imBalancedCloseBracket = 0;
        int imBalancedOpenBracket = 0;
        int minSwaps = 0;
        int unBalancedClosedBracket = 0;
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) == '[') {
                imBalancedOpenBracket++;
                if (unBalancedClosedBracket > 0) {
                    minSwaps += unBalancedClosedBracket;
                    unBalancedClosedBracket--;
                }
            } else {
                imBalancedCloseBracket++;
                unBalancedClosedBracket = Math.max(0, imBalancedCloseBracket - imBalancedOpenBracket);
            }
        }

        return minSwaps;
    }

    public static void main(String[] args) {
        String str = "[]]]][[[]][[[[]]";
        System.out.println(minimumNumberOfSwaps(str));
    }

}
