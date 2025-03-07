public class Solution {

 

    static int inf = Integer.MAX_VALUE / 2;

    static int[][][] dp = new int[31][31][51];

 

    public static int[] chocolateBar(int q, int[] n, int[] m, int[] k) {

        // Initializing DP matrix with -1.

        for (int i = 0; i < dp.length; ++i) {

            for (int j = 0; j < dp[i].length; ++j) {

                for (int l = 0; l < dp[i][j].length; ++l) {

                    dp[i][j][l] = -1;

                }

            }

        }

 

        // Storing answer of each query.

        int[] ans = new int[q];

        for (int i = 0; i < q; ++i) {

            ans[i] = solve(n[i], m[i], k[i]);

        }

 

        return ans;

    }

 

    /*

        This function will return the minimum to cut k chocolate pieces from the bar of dimensions n x m.

    */

 

    private static int solve(int n, int m, int k) {

 

        /*

              Base cases:

           1. When k is zero or k is equal to total size of matrix then cost will be zero.

           2. When k is less than zero or it is greater than size of matrix will be a invalid state

             so in this case we return infinitely large value.

        */

 

        if (k == 0 || k == n * m) {

            return 0;

        }

        if (k < 0 || k > n * m) {

            return inf;

        }

        // Return the answer if we already calculated it.

        if (dp[n][m][k] != -1) {

            return dp[n][m][k];

        }

 

        int ans = inf;

 

        // We try every possibility of cutting bar horizontally.

        for (int i = 1; i < n; ++i) {

            // Area of one bar will be m * i where i is side of new bar and m is the cut length.

            int area = i * m;

 

            /*

                  Here we have two bars with two possibilities:

               1. Keep the pieces of one bar and recur for remaining pieces on the other bar.

               2. Discard the one bar and recur on the same bar again.

 

            */

 

            int cost = m * m + Math.min(solve(i, m, k), solve(n - i, m, k - area));

            ans = Math.min(ans, cost);

        }

 

        // We try every possibility of cutting bar vertically.

        for (int j = 1; j < m; ++j) {

            // Area of one bar will be n * j where j is side of new bar and n is the cut length.

            int area = j * n;

            // Repeating same process as above.

            int cost = n * n + Math.min(solve(n, j, k), solve(n, m - j, k - area));

            ans = Math.min(ans, cost);

        }

        // Memoizing the answer.

        return dp[n][m][k] = ans;

    }

}
