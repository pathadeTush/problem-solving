import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/?envType=problem-list-v2&envId=topological-sort&
 */
public class CourseSchedule_II_210 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph[u].add(v);
        }

        Set<Integer> ans = new LinkedHashSet<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i]) {
                boolean possible = isPossible(i, graph, vis, pathVis, ans);
                if(!possible) {
                    return new int[]{};
                }
            }
        }

        System.out.println(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static boolean isPossible(int src, List<Integer>[] graph, boolean[] vis, boolean[] pathVis, Set<Integer> ans) {
        vis[src] = true;
        pathVis[src] = true;
        for(int ng: graph[src]) {
            if(!vis[ng]) {
                boolean possible = isPossible(ng, graph, vis, pathVis, ans);
                if(!possible) {
                    pathVis[src] = false;
                    return false;
                }
            } else if(pathVis[ng] == true) {
                pathVis[src] = false;
                return false;
            } else if(!ans.contains(ng)) {
                pathVis[src] = false;
                return false;
            }
        }

        pathVis[src] = false;
        ans.add(src);
        return true;
    }

    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequesites = new int[][]{{1,0}};
//        int numCourses = 4;
//        int[][] prerequesites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
//        int numCourses = 1;
//        int[][] prerequesites = new int[][]{};
//        int numCourses = 2;
//        int[][] prerequesites = new int[][]{{0, 1},{1,0}};
        int numCourses = 3;
        int[][] prerequesites = new int[][]{{0,2},{1,2},{2,0}};
        System.out.println(CourseSchedule_II_210.findOrder(numCourses, prerequesites));
    }

}
