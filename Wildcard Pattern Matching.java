import java.util.Arrays;

 

public class Solution {

    public static boolean wildcardMatching(String pattern, String text) {

        /*  Logic 

            1. If both the characters matches or there is a ?, both the characters matches

            and we reduce i and j

            2. if there is a *, it either macthes with empty emty string which means i-1

            or it matches with 1 character i.e j-1. we return true if anyone returns true

            3. If all the above cases are false we cannot match it return false

 

            Base case:

            1. if i<0 and j<0 all matches return 0;

            2. if i<0 and j>=0 we couldn't match all text so return false.

            3. if j<0 then for pattern to macth an empty string all the characters ahs to be

            *. return true else return false.

 

        */

        

        int n = pattern.length();

        int m = text.length();

 

        /*  Space Optimisation

            TC = O(N*M)

            SC = O(M)

 

        */

        //return chechMatchingSpaceOptimisation(n, m, pattern, text);

 

        /*  Tabulation

            TC = O(N*M)

            SC = O(N*M)

 

            return chechMatchingTabulatiom(n, m, pattern, text);

        */

        

        

        /*  Memoization

            TC = O(N*M)

            SC = O(N+M) + O(N*M)

 

            // 1- means  true 0 means false -1 means not calculated

            int[][] dp = new int[n+1][m+1];

            for(int[] row: dp){

                Arrays.fill(row, -1);

            }

            int ans = chechMatchingMemo(n, m, pattern, text, dp);

            if(ans==1) return true;

            return false;

 

        */

        

 

        /*  Recurrsion

            TC = O(2^N * 2^M)

            SC = O(N+M)

 

            

        */

        return chechMatching(n, m, pattern, text);

        

    }

 

    public static boolean chechMatchingSpaceOptimisation(int n, int m, String pattern, String text){

        boolean[] prev = new boolean[m+1];

 

        prev[0] = true;

        for(int j=1; j<=m; j++){

            prev[j] = false;

        }

 

        for(int i=1; i<=n; i++){

            boolean[] cur = new boolean[m+1];

            cur[0] = isAllStars(pattern, i);

            for(int j=1; j<=m; j++){

                if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?'){

                    cur[j] = prev[j-1];

                }else {

                    if(pattern.charAt(i-1)=='*'){

                        cur[j] = prev[j] || cur[j-1];

                    }else {

                        cur[j] = false;

                    }

                }

            }

            prev = cur;

        }

        return prev[m];

        

    }

 

    public static boolean chechMatchingTabulatiom(int n, int m, String pattern, String text){

        boolean[][] dp = new boolean[n+1][m+1];

 

        dp[0][0] = true;

        for(int j=1; j<=m; j++){

            dp[0][j] = false;

        }

 

        for(int i=1; i<=n; i++){

            dp[i][0]=isAllStars(pattern, i);

        }

        

        for(int i=1; i<=n; i++){

            for(int j=1; j<=m; j++){

                if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?'){

                    dp[i][j] = dp[i-1][j-1];

                }else {

                    if(pattern.charAt(i-1)=='*'){

                        dp[i][j] = dp[i-1][j] || dp[i][j-1];

                    }else {

                        dp[i][j] = false;

                    }

                }

            }

        }

        return dp[n][m];

        

    }

 

    public static boolean isAllStars(String pattern, int i){

        for(int j=1; j<=i; j++){

            if(pattern.charAt(j-1)!='*'){

                return false;

            }

        }

        return true;

    }

 

    public static int chechMatchingMemo(int i, int j, String pattern, String text, int[][] dp){

        if(i==0 && j==0) return 1;

        if(i==0 && j>0) return 0;

        if(j==0 && i>0){

            // Only all stars will match with "" j

            return isAllStars(pattern, i)==true ? 1:0;

        }

 

        if(dp[i][j]!=-1) return dp[i][j];

 

        if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?'){

            return dp[i][j] = chechMatchingMemo(i-1, j-1, pattern, text, dp);

        }

        if(pattern.charAt(i-1)=='*'){

            return dp[i][j] = (chechMatchingMemo(i-1, j, pattern, text, dp)==1 || chechMatchingMemo(i, j-1, pattern, text, dp)==1) ? 1: 0;

        }

        return 0;

    }

 

    public static boolean chechMatching(int i, int j, String pattern, String text){

        if(i==0 && j==0) return true;

        if(i==0 && j>0) return false;

        if(j==0 && i>0){

            // Only all stars will match with "" j

            return isAllStars(pattern, i);

        }

 

        if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?'){

            return chechMatching(i-1, j-1, pattern, text);

        }

        if(pattern.charAt(i-1)=='*'){

            return chechMatching(i-1, j, pattern, text) || chechMatching(i, j-1, pattern, text);

        }

        return false;

    }

}
