import java.util.* ;
import java.io.*; 
public class Solution {
    private static int dp[][];
    public static int maxCoins(int a[]) {
        // Write your code here..
        dp = new int[a.length+3][a.length+3];
        for(int ar[] : dp) Arrays.fill(ar, -1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i : a) list.add(i);
        list.add(1);
        return getMax(list, 1, a.length+1);
    }
    public static int getMax(List<Integer> list,int i, int j ){
        if( i == j)  return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i ; k < j ; k++){
            int steps = list.get(i-1) * list.get(k) * list.get(j) + getMax(list, i, k) + getMax(list, k+1, j);
            max = Math.max(max,steps);
        }
        return dp[i][j] = max;
    }

}
