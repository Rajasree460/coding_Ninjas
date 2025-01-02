public class Solution {

    public static class DisjointSet {
        List<Integer> size;
        List<Integer> parent;
        public DisjointSet(int n) {
            size = new ArrayList<>(Collections.nCopies(n+1, 1));
            parent = new ArrayList<>();
            for(int i=0; i<=n; i++) {
                parent.add(i);
            }
        }

        public void unionBySize(int u, int v) {
            int upU = findUltimateParent(u);
            int upV = findUltimateParent(v);
            if(size.get(upU) > size.get(upV)) {
                parent.set(upV, upU);
            } else if(size.get(upV) > size.get(upU)) {
                parent.set(upU, upV);
            } else {
                parent.set(upV, upU);
                size.set(upU, size.get(upU) + size.get(upV));
            }
        }

        public int findUltimateParent(int u) {
            if(u==parent.get(u)) {
                return u;
            }
            int upU = findUltimateParent(parent.get(u));
            parent.set(u, upU);
            return upU;
        }

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Write your code here.
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        int vertex = 0;
        for(List<String> account : accounts) {
            String accountOwner = account.get(0);
            updateMap(account, map, vertex, ds);
            vertex+=1;
        }

        Map<Integer, List<String>> newMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int u = entry.getValue();
            int upU = ds.findUltimateParent(u);
            List<String> temp = newMap.getOrDefault(upU, new ArrayList<>());
            temp.add(email);
            newMap.put(upU, temp);
        }

        List<List<String>> finalAns = new ArrayList<>();
        int index = 0;
        for(Map.Entry<Integer, List<String>> entry : newMap.entrySet()) {
            int upU = entry.getKey();
            List<String> temp = entry.getValue();
            Collections.sort(temp);
            String name = accounts.get(upU).get(0);
            finalAns.add(new ArrayList<>());
            finalAns.get(index).add(name);
            finalAns.get(index).addAll(temp);
            index+=1;
        }
        return finalAns;
    }

    public static void updateMap(List<String> account, Map<String, Integer> map, int vertex, DisjointSet ds) {
        for(int i=1; i<account.size(); i++) {
            String email = account.get(i);
            if(map.containsKey(email)) {
                ds.unionBySize(map.get(email), vertex);
            } else {
                map.put(email, vertex);
            }
        }
    }
}
