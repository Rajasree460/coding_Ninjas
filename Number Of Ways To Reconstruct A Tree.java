import java.util.*;

public class Solution {
    public static int findWays(ArrayList<ArrayList<Integer>> pairs, int n) {
        // Create adjacency list
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (ArrayList<Integer> pair : pairs) {
            adj.putIfAbsent(pair.get(0), new HashSet<>());
            adj.putIfAbsent(pair.get(1), new HashSet<>());
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }

        // Max-Heap to prioritize nodes by their degrees
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()) {
            pq.offer(new int[]{entry.getValue().size(), entry.getKey()});
        }

        int totalNodes = pq.size();
        Set<Integer> visited = new HashSet<>();
        int ans = 1;

        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int currDegree = currNode[0];
            int currId = currNode[1];
            int parent = -1;
            int parentSize = Integer.MAX_VALUE;

            // Find the best parent node
            for (int neighbor : adj.get(currId)) {
                if (visited.contains(neighbor) && adj.get(neighbor).size() < parentSize && adj.get(neighbor).size() >= currDegree) {
                    parent = neighbor;
                    parentSize = adj.get(neighbor).size();
                }
            }

            visited.add(currId);

            // If no parent found
            if (parent == -1) {
                if (currDegree != totalNodes - 1) {
                    return 0; // Incomplete connections
                }
                continue; // Move to next
            }

            // Check connections with the parent
            for (int neighbor : adj.get(currId)) {
                if (neighbor != parent && !adj.get(parent).contains(neighbor)) {
                    return 0; // Missing connection
                }
            }

            // Check if current node has the same degree as the parent
            if (currDegree == parentSize) {
                ans = 2; // More than one way
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
        pairs.add(new ArrayList<>(Arrays.asList(2, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 3)));

        int n = 3; // Number of nodes
        System.out.println(findWays(pairs, n)); // Output the result
    }
}
