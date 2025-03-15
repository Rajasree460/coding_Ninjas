import java.util.*;

public class Solution {

    public static int minimumTimeTakingPath(int[][] heights){

        int n = heights.length;

        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int[][] dp = new int[n][m];

        for (int[] row : dp) 

            Arrays.fill(row, Integer.MAX_VALUE);

        int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        pq.offer(new int[]{0, 0, 0});

        dp[0][0] = 0;

 

        while (!pq.isEmpty()) {

            int[] cell = pq.poll();

            int row = cell[0];

            int col = cell[1];

            int effort = cell[2];

 

            if (row == n - 1 && col == m - 1) {

                return effort;

            }

 

            for (int[] dir : arr) {

                int newRow = row + dir[0];

                int newCol = col + dir[1];

 

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {

                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));

 

                    if (newEffort < dp[newRow][newCol]) {

                        dp[newRow][newCol] = newEffort;

                        pq.offer(new int[]{newRow, newCol, newEffort});

                    }

                }

            }

        }

        return 0; 

    }

}

 
