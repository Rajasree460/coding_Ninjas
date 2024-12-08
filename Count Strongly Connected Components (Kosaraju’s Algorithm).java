import java.util.*;

public class Solution {

    static Stack<Integer> stack;

    static boolean[] visited;

 

    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {

            adjList.add(new ArrayList<>());

        }

        for (ArrayList<Integer> edge : edges) {

            int from = edge.get(0);

            int to = edge.get(1);

            adjList.get(from).add(to);

        }

        stack = new Stack<>();

        visited = new boolean[v];

        for (int i = 0; i < v; i++) {

            if (!visited[i]) {

                topologicalDFS(i, adjList);

            }

        }

        ArrayList<ArrayList<Integer>> reversedGraph = reverseArrayGraph(adjList);

        visited = new boolean[v];

        int count = 0;

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (!visited[node]) {

                count++;

                dfs(node, reversedGraph);

            }

        }

        return count;

    }

        public static void topologicalDFS(int idx, ArrayList<ArrayList<Integer>> edges) {

        if (visited[idx])

            return;

        visited[idx] = true;

 

        for (int nbr : edges.get(idx)) {

            topologicalDFS(nbr, edges);

        }

        stack.add(idx);

    }

    public static ArrayList<ArrayList<Integer>> reverseArrayGraph(ArrayList<ArrayList<Integer>> edges) {

        int n = edges.size();

        ArrayList<ArrayList<Integer>> reversedEdges = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {

            reversedEdges.add(new ArrayList<>());

        }

        for (int u = 0; u < n; u++) {

            for (int v : edges.get(u)) {

                reversedEdges.get(v).add(u);

            }

        }

 

        return reversedEdges;

    }

    public static void dfs(int idx, ArrayList<ArrayList<Integer>> edges) {

        if (visited[idx])

            return;

        visited[idx] = true;

 

        for (int nbr : edges.get(idx)) {

            dfs(nbr, edges);

        }

    }

}
