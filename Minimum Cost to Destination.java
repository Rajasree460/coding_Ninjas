import java.util.*;

 

public class Solution {

 

    private static final int[] drow = {0, 0, -1, 1};

    private static final int[] dcol = {-1, 1, 0, 0};

 

    public static int minCostToDestination(int[][] matrix, int x, int y) {

        if (matrix[0][0] == 0) return -1;

 

        Queue<int[]> pq = new LinkedList<>();

        pq.offer(new int[]{0, 0, 0});

 

        int n = matrix.length;

        int m = matrix[0].length;

 

        int[][] minCost = new int[n][m];

        for (int i = 0; i < n; i++) {

            Arrays.fill(minCost[i], Integer.MAX_VALUE);

        }

 

        while (!pq.isEmpty()) {

            int[] it = pq.poll();

            int cost = it[0];

            int row = it[1];

            int col = it[2];

 

            for (int i = 0; i < 4; i++) {

                int nrow = row + drow[i];

                int ncol = col + dcol[i];

 

                if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || matrix[nrow][ncol] == 0) continue;

 

                if (i <= 1 && minCost[nrow][ncol] > cost) {

                    minCost[nrow][ncol] = cost;

                    pq.offer(new int[]{cost, nrow, ncol});

                } else if (i > 1 && minCost[nrow][ncol] > 1 + cost) {

                    minCost[nrow][ncol] = 1 + cost;

                    pq.offer(new int[]{cost + 1, nrow, ncol});

                }

            }

        }

 

        return minCost[x][y] == Integer.MAX_VALUE ? -1 : minCost[x][y];

    }

}
