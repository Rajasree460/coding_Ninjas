import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;

public class Solution {

   public static int findMaxFlow(int n, int m, ArrayList<ArrayList<Integer>> pipes) {

       int[][] graph = new int[n + 1][n + 1];

       for (ArrayList<Integer> pipe : pipes) {

           int from = pipe.get(0);

           int to = pipe.get(1);

           int weight = pipe.get(2);

           graph[from][to] += weight;

           graph[to][from] += weight;

       }

       int maxFlow = fordFulkerson(1, n, graph);

       return maxFlow;

   }

   public static int fordFulkerson(int source, int sink, int[][] graph) {

       int[][] residualGraph = new int[graph.length][graph.length];

       for (int i = 0; i < graph.length; i++) {

           for (int j = 0; j < graph.length; j++) {

               residualGraph[i][j] = graph[i][j];

           }

       }

       int[] parent = new int[graph.length];

       int maxFlow = 0;

       while (BFS(residualGraph, source, sink, parent)) {

           int capacity = (int) 1e9;

           int t = sink;

           while (t != source) {

               int s = parent[t];

               capacity = Math.min(capacity, residualGraph[s][t]);

               t = s;

           }

           t = sink;

           while (t != source) {

               int s = parent[t];

               residualGraph[s][t] -= capacity;

               t = s;

           }

           maxFlow += capacity;

       }

       return maxFlow;

   }

   public static boolean BFS(int[][] residualGraph, int src, int dest, int[] parent) {

       boolean[] visited = new boolean[parent.length];

       Queue<Integer> queue = new LinkedList<>();

       queue.add(src);

       parent[src] = -1;

       visited[src] = true;

       while (!queue.isEmpty()) {

           int u = queue.poll();

 

           for (int v = 0; v < parent.length; v++) {

               if (!visited[v] && residualGraph[u][v] > 0) {

                   queue.add(v);

                   parent[v] = u;

                   visited[v] = true;

               }

           }

       }

       return visited[dest];

   }

}

 
