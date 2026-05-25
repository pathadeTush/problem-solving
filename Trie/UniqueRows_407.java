import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueRows_407 {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 0},{0, 0, 1},{0, 1, 0}, {0, 1, 1}, {1, 0, 0}};
        System.out.println(uniqueRow(a, a.length, a[0].length));
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        Set<ArrayList<Integer>> uniqueRows = new LinkedHashSet<>();
        for (int row = 0; row < r; row++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int col = 0; col < c; col++) {
                list.add(a[row][col]);
            }

            uniqueRows.add(list);
        }

        return new ArrayList<>(new ArrayList<>(uniqueRows));
    }

}
