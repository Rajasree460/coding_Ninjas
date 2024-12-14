import java.util.* ;
import java.io.*; 
public class Solution
{
    private static int dp[][][][];
    public static boolean isScramble(String s, String r)
    {
        // Write your code here.
        if(s.equals(r)) return true;
        int n = s.length();
        dp = new int[n+1][n+1][n+1][n+1];
        for(int [][][]temp1 : dp){
            for(int temp2[][] : temp1){
                for(int temp3[] : temp2) Arrays.fill(temp3,-1);
            }
        }
        return isPossible(s, r, 0, s.length()-1, 0, s.length()-1);

    }
     public static boolean isPossible(String s, String r,int i,int j,int a,int b){
        // if( a >= s.length() || b >= s.length()) return false;
        if (j - i + 1 == 1) {
            return s.charAt(i) == r.charAt(a);
        }
        if(dp[i][j][a][b] != -1) return dp[i][j][a][b] == 0 ? false : true;
        for (int k = i, c = 0; k <= j - 1; k++, c++) {
            boolean s1 = isPossible(s, r, i, k, a, a + c) && isPossible(s, r, k + 1, j, a + c + 1, b);
            boolean s2 = isPossible(s, r, k + 1, j, a, b - c - 1) && isPossible(s, r, i, k, b - c , b);
            if (s1 || s2) {
                dp[i][j][a][b] = 1;
                return true;
            }
        }
        dp[i][j][a][b] = 0;
        return false;
    }
}
