public class Solution {

    public static int CountSumConsecutiveNums(int n) {

        long maxSum = 0;

        int m = 1;

        while (maxSum <= n) {

            maxSum += m;

            m++;

        }

        int sum = 1;

        int ans = 0;

        for (int i = 2; i < m - 1; i++) {

            if ((n - sum) % i == 0) {

                ans++;

            }

            sum += i;

        }

        return ans;

    }

}
