import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    // Record class for Node
    record Node(int row, int column, int distance) {}

    // Record class for Edge
    record Edge(int destRow, int destColumn, int weight) {}

    public static int minDirectionChanges(final char[][] grid, final int n, final int m) {
        // Initializing the Node array
        Node[][] arr = new Node[n][m];
        IntStream.range(0, n).forEach(i->
               IntStream.range(0, m).forEach(j->{
               arr[i][j]=new Node(i, j, (int) 1e6);}));

        // Initializing the adjacency list
        ArrayList<Edge>[][] adj = new ArrayList[n][m];
        IntStream.range(0, n).forEach(i->
               IntStream.range(0, m).forEach(j->{
                adj[i][j] = new ArrayList<>();}));

        // Traversing the grid and populating the adjacency list
        IntStream.range(0, n).forEach(i->
               IntStream.range(0, m).forEach(j->{
                if (i + 1 < n)
                    adj[i][j].add(new Edge(i + 1, j, grid[i][j] == 'D' ? 0 : 1));
                if (i > 0)
                    adj[i][j].add(new Edge(i - 1, j, grid[i][j] == 'U' ? 0 : 1));
                if (j + 1 < m)
                    adj[i][j].add(new Edge(i, j + 1, grid[i][j] == 'R' ? 0 : 1));
                if (j > 0)
                    adj[i][j].add(new Edge(i, j - 1, grid[i][j] == 'L' ? 0 : 1));
            }
               ));

        // Initializing the priority-queue and pushing start node
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::distance));
        arr[0][0] = new Node(0, 0, 0);
        pq.add(arr[0][0]);

        // Traversing the priority-queue
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            adj[current.row][current.column].forEach(curr_edge->{
                if ((curr_edge.weight + current.distance) < arr[curr_edge.destRow][curr_edge.destColumn].distance) {
                    arr[curr_edge.destRow][curr_edge.destColumn] = new Node(
                            curr_edge.destRow,
                            curr_edge.destColumn,
                            curr_edge.weight + current.distance
                    );
                    pq.add(arr[curr_edge.destRow][curr_edge.destColumn]);
                }
            });
        }

        // Returning minimum-distance
        return arr[n - 1][m - 1].distance;
    }
}
