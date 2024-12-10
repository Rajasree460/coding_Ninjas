import java.util.* ;

import java.io.*; 

public class Solution {

    public static int longestPalindromeSubsequence(String s) {

        int i, j, n = s.length(), ans = 1;

        int[] curr, prev = new int[n+1];

        for(i=1; i<=n; i++){

            curr = new int[n+1];

            for(j=i; j>0; j--){

                if (i == j)

                    curr[j] = 1;

                else if (s.charAt(i-1)==s.charAt(j-1))

                    curr[j] = prev[j+1]+2;

                else

                    curr[j] = Math.max(curr[j+1], prev[j]);

                ans = Math.max(ans, curr[j]);

            }

            prev = curr;

        }

        return ans;

    }

}
