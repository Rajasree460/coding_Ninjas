import java.util.*;

 

public class Solution {

    public static int helper(String str, int n, int curIdx, int k, int prevChar, int cntPrevChar, int[][][][] dp) {

 

        if (curIdx == n)

            return 0;

 

        if (dp[curIdx][k][prevChar][cntPrevChar] != -1)

            return dp[curIdx][k][prevChar][cntPrevChar];

 

        int result = n + 1;

 

    

        if (k > 0)

            result = helper(str, n, curIdx + 1, k - 1, prevChar, cntPrevChar, dp);

 

        if (str.charAt(curIdx) - 'a' == prevChar) {

  

            int increment = 0;

 

            if (cntPrevChar == 1 || cntPrevChar == 9 || cntPrevChar == 99)

                increment = 1;

 

            result = Math.min(result, helper(str, n, curIdx + 1, k, prevChar, cntPrevChar + 1, dp) + increment);

        } else {

       

            result = Math.min(result, helper(str, n, curIdx + 1, k, str.charAt(curIdx) - 'a', 1, dp) + 1);

        }

 

        dp[curIdx][k][prevChar][cntPrevChar] = result;

 

        return dp[curIdx][k][prevChar][cntPrevChar];

    }

 

    public static int minLengthOfCompressedString(String str, int k) {

  

        int n = str.length();

 

        int[][][][] dp = new int[n][k + 1][27][n + 1];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                for (int p = 0; p < 27; p++) {

                    Arrays.fill(dp[i][j][p], -1);

                }

            }

        }

        return helper(str, n, 0, k, 26, 0, dp);

    }

}
