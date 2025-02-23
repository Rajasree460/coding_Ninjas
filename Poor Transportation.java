import java.util.* ;

import java.io.*; 

 

public class Solution {

    static List<List<Integer>> graph;

    static int[][] capacity;

    static int[] R;

    static int[] C;

    static int[] visited;

    static int[] parent;

 

    public static int[] maxTrucks(int N, int M, int P, int D, int[][] permits, int[] cap, int[][] reduction) {

        // Write your code here

        graph = new ArrayList<>(N + M + 2);

        for (int i = 0; i <= N + M + 1; i++) {

            graph.add(new ArrayList<>());

        }

        capacity = new int[N + M + 2][N + M + 2];

        R = new int[1003];

        C = new int[1003];

        visited = new int[1004];

        parent = new int[1004];

 

        for (int i = 1; i <= N; i++) {

            graph.get(0).add(i);

            graph.get(i).add(0);

            capacity[0][i] = 1;

        }

 

        for (int i = 1; i <= P; i++) {

            int u = permits[i - 1][0];

            int v = permits[i - 1][1];

            graph.get(u).add(v + N);

            graph.get(v + N).add(u);

            capacity[u][v + N] = 1;

        }

 

        for (int i = N + 1; i <= N + M; i++) {

            graph.get(i).add(N + M + 1);

            graph.get(N + M + 1).add(i);

            capacity[i][N + M + 1] = cap[i - N - 1];

        }

 

        for (int i = 1; i <= D; i++) {

            R[i] = reduction[i - 1][0];

            C[i] = reduction[i - 1][1];

            capacity[N + R[i]][N + M + 1] -= C[i];

        }

 

        int initialMaxFlow = maxFlow(0, N + M + 1, N, M);

        List<Integer> ans = new ArrayList<>();

        while (D > 0) {

            capacity[N + R[D]][N + M + 1] += C[D];

            initialMaxFlow += maxFlow(0, N + M + 1, N, M);

            ans.add(initialMaxFlow);

            D--;

        }

        Collections.reverse(ans);

        return ans.stream().mapToInt(i -> i).toArray();

    }

    public static boolean getAugumentedpath(int s, int t) {

        visited[s] = 1;

 

        for (int i = 0; i < graph.get(s).size(); i++) {

            int adj = graph.get(s).get(i);

            if (visited[adj] == 0 && capacity[s][adj] > 0) {

                parent[adj] = s;

                if (adj == t) {

                    return true;

                }

                if (getAugumentedpath(adj, t)) {

                    return true;

                }

                parent[adj] = -1;

            }

        }

        return false;

    }

 

    public static int updateAugumentedPath(int N, int M) {

        int minCap = 100000000;

        int node = N + M + 1;

        while (parent[node] != -1) {

            int temp = parent[node];

            minCap = Math.min(minCap, capacity[temp][node]);

            node = temp;

        }

        node = N + M + 1;

        while (parent[node] != -1) {

            int temp = parent[node];

            capacity[temp][node] -= minCap;

            capacity[node][temp] += minCap;

            node = temp;

        }

        return minCap;

    }

 

    public static int maxFlow(int s, int t, int N, int M) {

        int ans = 0;

        int f = 0;

        while (f == 0) {

            for (int i = 0; i < 1003; i++) {

                visited[i] = 0;

                parent[i] = -1;

            }

            if (getAugumentedpath(s, t)) {

                ans += updateAugumentedPath(N, M);

            } else {

                f = 1;

            }

        }

        return ans;

    }

 

}
