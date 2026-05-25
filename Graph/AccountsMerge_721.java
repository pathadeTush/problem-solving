import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * http://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge_721 {

    public static class DisjointSet {
        private int len;
        private int[] parent;
        private int[] size;

        public DisjointSet(int len) {
            this.len = len;
            parent = new int[len];
            size = new int[len];

            for(int i = 0; i < len; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void unionBySize(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);

            if(parentU == parentV) {
                return;
            }

            if(size[parentU] >= size[parentV]) {
                size[parentU] += size[parentV];
                parent[parentV] = parentU;
            } else {
             size[parentV] += size[parentU];
             parent[parentU] = parentV;
            }
        }

        public int findParent(int u) {
            if(parent[u] == u) {
                return u;
            }

            return parent[u] = findParent(parent[u]);
        }
    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        DisjointSet set = new DisjointSet();
//
//        for(List<String> list: accounts) {
//            int emailLen = list.size();
//            for(int i = 1; i < emailLen; i++) {
//                set.unionBySize(list.get(0), list.get(i));
//            }
//        }
//
//
//    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> emailNameIdsMap = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            int emailCount = accounts.get(i).size();
            Map<String, Integer> map = new HashMap<>();
            boolean found = false;
            int idx = -1;
            for (int j = 1; j < emailCount; j++) {
                if (emailNameIdsMap.containsKey(accounts.get(i).get(j))) {
                    found = true;
                    idx = emailNameIdsMap.get(accounts.get(i).get(j));
                    disjointSet.unionBySize(idx, i);
                } else {
                    map.put(accounts.get(i).get(j), i);
                }
            }
            if (!found) {
                emailNameIdsMap.putAll(map);
            } else {
                for (int j = 1; j < emailCount; j++) {
                    emailNameIdsMap.put(accounts.get(i).get(j), idx);
                }
            }
        }

        Map<Integer, TreeSet<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            TreeSet<String> set = map.getOrDefault(disjointSet.findParent(i), new TreeSet<>());
            for(int j = 1; j < accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
            map.put(disjointSet.findParent(i), set);
        }

        return map.entrySet().stream().map(entry -> {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0));
            list.addAll(entry.getValue().stream().toList());
            return list;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        List<List<String>> accounts = new ArrayList<>();
//        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
//        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
//        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
//        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));

        System.out.println(AccountsMerge_721.accountsMerge(accounts));
    }

}
