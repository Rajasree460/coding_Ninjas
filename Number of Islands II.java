import java.util.*;
public class Solution {
    public static boolean isValid(int x, int y, int n, int m) {
        if(x >= n || y >= m || x < 0 || y < 0) return false;
        return true;
    }
    
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] visited = new boolean[n][m];
        int[] res = new int[q.length];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int count = 0;
        for(int i = 0; i < q.length; i++) {
            int r = q[i][0];
            int c = q[i][1];
            int node = r * m + c;
            if(visited[r][c]) {
                res[i] = count;
                continue;
            }
            visited[r][c] = true;
            count++;
            for(int j = 0; j < 4; j++) {
                int newr = r + dx[j];
                int newc = c + dy[j];
                int newNode = newr * m + newc;
                if(isValid(newr, newc, n, m) && visited[newr][newc] && ds.findUPar(node) != ds.findUPar(newNode)) {
                    ds.unionByRank(newNode, node);
                    count--;
                }
            }
            res[i] = count;
        }
        return res;
        
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public boolean unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return false;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
        return true;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
