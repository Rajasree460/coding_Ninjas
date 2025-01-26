public class Solution {

 

    static boolean findTarget(int[] arr, int n, Boolean[][] dp, int target) {

        if (target == 0) return true;

        if (n == 0) return arr[0] == target;

 

        if (dp[n][target] != null) return dp[n][target];

 

        boolean notTake = findTarget(arr, n - 1, dp, target);

        boolean take = false;

 

        if (target >= arr[n]) {

            take = findTarget(arr, n - 1, dp, target - arr[n]);

        }

 

        return dp[n][target] = take || notTake;

    }

 

    public static int minSubsetSumDifference(int[] arr, int n) {

        int totalSum = 0;

        for (int num : arr) {

            totalSum += num;

        }

 

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

 

        int maxSubsetSum = 0;

        for (int i = target; i >= 0; i--) {

            if (findTarget(arr, n - 1, dp, i)) {

                maxSubsetSum = i;

                break;

            }

        }

 

        return Math.abs(totalSum - 2 * maxSubsetSum);

    }

}
