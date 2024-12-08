import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Variables used in DFS
    private static int time; // Time counter used in DFS
    private static List<List<Integer>> result; // List to store the critical connections

    public static ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> connections) {
        // Initialize/reset variables
        time = 0;
        result = new ArrayList<>();

        // Initialize graph as adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with the connections
        for (ArrayList<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Arrays to keep track of discovery times and lowest point reachable
        int[] discovery = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize discovery and low arrays
        for (int i = 0; i < n; i++) {
            discovery[i] = -1;
            low[i] = -1;
        }

        // Perform DFS from the first node (assuming 0 as starting point)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, discovery, low, visited, graph);
            }
        }

        // Convert result list to required format
        ArrayList<ArrayList<Integer>> criticalConnections = new ArrayList<>();
        for (List<Integer> edge : result) {
            criticalConnections.add(new ArrayList<>(edge));
        }

        return criticalConnections;
    }

    private static void dfs(int u, int parent, int[] discovery, int[] low, boolean[] visited, List<List<Integer>> graph) {
        visited[u] = true;
        discovery[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (v == parent) {
                continue; // Skip the parent of the current node
            }

            if (!visited[v]) {
                dfs(v, u, discovery, low, visited, graph);

                // Check if the subtree rooted at v has a connection back to one of u's ancestors
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge
                if (low[v] > discovery[u]) {
                    result.add(List.of(u, v));
                }
            } else {
                // Update low value of u for parent function calls
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

}
