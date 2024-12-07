import java.util.*;

 

public class Solution {

 

    public static void dfs(int si, int p, int[] distance, int[] subtree, ArrayList<Integer>[] tree) {

        for (int i : tree[si]) {

            if (i == p) {

                continue;

            }

 

            dfs(i, si, distance, subtree, tree);

            // Adding the distance of ith subtree to si.

            distance[si] += distance[i] + subtree[i];

            // Updating the subtree size.

            subtree[si] += subtree[i];

        }

 

        // Incrementing it by 1 to add the current node.

        subtree[si]++;

    }

 

    public static void dfs1(int si, int p, int[] distance, int[] subtree, ArrayList<Integer>[] tree) {

        if (si != p) {

            /*

                Updating the ans for si node using its parent by adding distance of

                p and excluding the value of si node.

            */

            distance[si] += (distance[p] - distance[si] - subtree[si]) + (subtree[p] - subtree[si]);

 

            subtree[si] += subtree[p] - subtree[si];

 

        }

 

        for (int i : tree[si]) {

            if (i == p) {

                continue;

            }

 

            dfs1(i, si, distance, subtree, tree);

        }

    }

 

    public static int[] sumOfDistance(int[][] edges, int n) {

        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            tree[i] = new ArrayList<>();

        }

        for (int[] edge : edges) {

            tree[edge[0]].add(edge[1]);

            tree[edge[1]].add(edge[0]);

        }

 

        int[] ans = new int[n];

        int[] subtree = new int[n];

 

        dfs(0, 0, ans, subtree, tree);

 

        dfs1(0, 0, ans, subtree, tree);

 

        return ans;

    }

 

    public static void main(String[] args) {

        // Example usage:

        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};

        int n = 6;

        int[] result = sumOfDistance(edges, n);

        System.out.println(Arrays.toString(result));

    }

}
