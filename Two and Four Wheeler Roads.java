import java.util.ArrayList;

public class Solution {
    // Dfs function to check the connectivity of the graph.
    public  static int dfs(int pos,int [] visited,ArrayList<Integer>[] a){
        int cnt = 1;
        visited[pos] = 1;
        for ( int x =0 ; x<(a[pos].size());x++){
            if (visited[a[pos].get(x)] != 1){
                cnt = cnt+ (dfs(a[pos].get(x), visited, a));
            }
        }
        return cnt;

    }
    public static int twoFourWheelRoads(int[][] arr, int n, int m) {
        // Declaring 3 ArrayLists to store all the type of links between cities.
        ArrayList<Integer>[] graph1 = new ArrayList[n];
        ArrayList<Integer>[] graph2 = new ArrayList[n];
        ArrayList<Integer>[] graph3 = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph1[i] = new ArrayList<Integer>();
            graph2[i] = new ArrayList<Integer>();
            graph3[i] = new ArrayList<Integer>();
        }

        // Iterating for all the 'm' roads and building the connections of link between cities in graph vectors.
        for (int i = 0; i < m; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            int z = arr[i][2];
            x--;
            y--;

            // If it is a Road of type 1, then add links in graph 1.
            if (z == 1){
                graph1[x].add(y);
                graph1[y].add(x);
            }
            // If it is a Road of type 2, then add links in graph 2.
            else if (z == 2){
                graph2[x].add(y);
                graph2[y].add(x);
            }
            // If it is a Road of type 3, then add links in all the three graphs.
            else{
                graph1[x].add(y);
                graph1[y].add(x);

                graph2[x].add(y);
                graph2[y].add(x);

                graph3[x].add(y);
                graph3[y].add(x);
                graph3[x].add(y);
                graph3[y].add(x);
            }
        }

        // Array to store and keep a check on the the visited indices.
        int [] visited=new int[n];

        // Check Connectivity of Graph 1.
        for (int i = 0; i < n; i++){
            visited[i] = 0;
        }
        int cnt = dfs(0, visited, graph1);
        // Return -1 if Nodes in ArrayList 1 is not fully connected.
        if (cnt != n){
            return -1;
        }

        // Check Connectivity of Graph 2.
        for (int i = 0; i < n; i++){
            visited[i] = 0;
        }
        cnt = dfs(0, visited, graph2);
        // Return -1 if Nodes in ArrayList 2 is not fully connected.
        if (cnt != n){
            return -1;
        }

        // Variable to store the count of already used roads during a itarative check on all roads and cities.
        int usedRoads = 0;
        for (int i = 0; i < n; i++){
            visited[i] = 0;
        }

        // Variable to store the count of components.
        int components = 0;

        // Iterating each city to have a count of already used roads between cities.
        for (int i = 0; i < n; i++){
            if (visited[i]!=1){
                cnt = dfs(i, visited, graph3);
                usedRoads += (cnt - 1);
                components++;
            }
        }
        usedRoads += ((components - 1) * 2);

        // Store the maximum number of roads to be removed in the result and return it.
        int result = m - usedRoads;
        return result;
    }
}
