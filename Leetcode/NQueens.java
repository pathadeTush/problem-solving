import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<int[]>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<int[]> item = new ArrayList<>();
            item.add(new int[] {0, i});
            find(1, n, item, ans);
            item.remove(0);
        }

        List<List<String>> sol = new ArrayList<>();
        int totalAns = ans.size();
        for(int i = 0; i < totalAns; i++) {
            List<String> pair = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                StringBuilder sb = new StringBuilder(new String(chars));
                sb.setCharAt(ans.get(i).get(j)[1], 'Q');
                pair.add(sb.toString());
            }
            sol.add(pair);
        }

        return sol;
    }

    public void find(int row, int n, List<int[]> item, List<List<int[]>> ans) {
        if(row >= n) {
            List<int[]> copy = new ArrayList<>(item);
            ans.add(copy);
            return;
        }

        for(int i = 0; i < n; i++) {
            int x = row;
            int y = i;
            if(isValid(x, y, item)) {
                item.add(new int[]{x, y});
                find(row+1, n, item, ans);
                item.remove(item.size()-1);
            }
        }
    }

    public boolean isValid(int x, int y, List<int[]> item) {
        int len = item.size();
        for(int i = 0; i < len; i++) {
            int j = item.get(i)[0];
            int k = item.get(i)[1];
            if(x == j || y == k || Math.abs(x-j) == Math.abs(y - k)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}
