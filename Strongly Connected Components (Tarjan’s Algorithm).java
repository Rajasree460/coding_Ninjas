import java.util.*;

public class Solution {
    private static void dfsRev(int node, ArrayList<ArrayList<Integer>> adjT, int[] isVisited, List<Integer> compo) {
        isVisited[node] = 1;
        compo.add(node);

        for (int adjNode : adjT.get(node)) {
            if(isVisited[adjNode] == 0)
                dfsRev(adjNode, adjT, isVisited, compo);
        } 
    }
    private static void dfs(int node, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int[] isVisited) {
        isVisited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if(isVisited[adjNode] == 0) 
                dfs(adjNode, stack, adj, isVisited);
        }

        stack.push(node);
    }

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);
        
        int[] isVisited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(isVisited[i] == 0) dfs(i, stack, adj, isVisited);
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < n; i++) adjT.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            isVisited[i] = 0;
            for (int it : adj.get(i)) adjT.get(it).add(i);
        }
    
        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if(isVisited[node] == 0) {
                List<Integer> compo = new ArrayList<>();
                dfsRev(node, adjT, isVisited, compo);
                ans.add(compo);
            }
            
        }

        return ans;
    }
}
