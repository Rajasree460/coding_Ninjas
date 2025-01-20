import java.util.*;

public class Solution {

   public static int fireInTheCells(int[][] mat, int N, int M, int X, int Y) {
       int[][] fire = new int[N][M];
       Queue<int[]> q = new LinkedList<>();
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               if (mat[i][j] == 0) {
                   q.offer(new int[]{0, i, j});
                   fire[i][j] = 0;
               } else {
                   fire[i][j] = -1;
               }
           }
       }

       int[] drow = {0, 0, -1, 1};
       int[] dcol = {-1, 1, 0, 0};


       while (!q.isEmpty()) {
           int[] curr = q.poll();
           int count = curr[0];
           int row = curr[1];
           int col = curr[2];

           for (int i = 0; i < 4; i++) {
               int nrow = row + drow[i];
               int ncol = col + dcol[i];

               if (nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
                   if (fire[nrow][ncol] == -1) {
                       q.offer(new int[]{count + 1, nrow, ncol});
                       fire[nrow][ncol] = count + 1;
                   }
               }
           }
       }


       if (fire[X][Y] == 0 && X != 0 && Y != 0 && X != N - 1 && Y != M - 1) return -1;

       Queue<int[]> q2 = new LinkedList<>();
       q2.offer(new int[]{0, X, Y});

       while (!q2.isEmpty()) {
           int[] curr = q2.poll();
           int count = curr[0];
           int xcor = curr[1];
           int ycor = curr[2];

           if ((xcor == 0 && ycor != 0 && ycor != M - 1) ||
               (xcor == N - 1 && ycor != 0 && ycor != M - 1) ||
               (xcor != 0 && ycor == 0 && xcor != N - 1) ||
               (xcor != N - 1 && xcor != 0 && ycor == M - 1)) {
               return count;
           }

           for (int i = 0; i < 4; i++) {
               int nrow = xcor + drow[i];
               int ncol = ycor + dcol[i];

               if (nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
                   if (fire[nrow][ncol] > count + 1) {
                       q2.offer(new int[]{count + 1, nrow, ncol});
                   }
               }
           }
       }

       return -1;
   }

   public static void main(String[] args) {
       int[][] mat = {
           {1, 1, 1, 1, 1},
           {1, 0, 0, 0, 1},
           {1, 0, 1, 0, 1},
           {1, 0, 0, 0, 1},
           {1, 1, 1, 1, 1}
       };

       int N = mat.length;
       int M = mat[0].length;
       int X = 1;
       int Y = 1;

       int result = fireInTheCells(mat, N, M, X, Y);
       System.out.println("Minimum time to escape: " + result);
   }
}
