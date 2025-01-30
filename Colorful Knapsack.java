import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

public class Solution {

    private static long dp[][];

    public static int colorfulKnapsack(int w[], int c[], int m, int x) {

        //    Your code goes here.

        List<Integer> list[] = new ArrayList[m];

        int color = 0;

        for(int i = 0 ; i < w.length ; i++){

            if(list[c[i]-1] == null) {

                color++;

                list[c[i]-1] = new ArrayList<>();

            }

            list[c[i]-1].add(w[i]);

        }

        if(color != m) return -1;

        dp = new long[m+1][x+1];

        for(long t[] : dp)Arrays.fill(t, -1);

        long ans = getMin(0, list, x, 0);

        return ans >= Integer.MAX_VALUE ? -1 : (int)ans;

    }

    public static long getMin(int idx,List<Integer> list[],int x,int currWeight){

        if(idx == list.length){

            return x - currWeight;

        }

        if(dp[idx][currWeight] != -1) return dp[idx][currWeight];

        long min = Integer.MAX_VALUE;

        for(int temp : list[idx]){

            if(temp + currWeight <= x){

                min = Math.min(min,getMin(idx+1, list, x, currWeight+temp));

            }

        }

        return dp[idx][currWeight] =  min;

    }

}
