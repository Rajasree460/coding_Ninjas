import java.util.*;

 

public class Solution

{

    public static int maxProfit(ArrayList<Integer> prices, int n)

    {

        int[] frontArr = new int[n];

        int[] backArr = new int[n];

        Arrays.fill(frontArr, 0);

        Arrays.fill(backArr, 0);

        int m = prices.get(0);

        for (int i = 1; i < n; i++)

        {

            frontArr[i] = Math.max(prices.get(i) - m, frontArr[i - 1]);

            m = Math.min(prices.get(i), m);

        }

        int M = prices.get(prices.size() - 1);

        for (int i = prices.size() - 2; i >= 0; i--){

            backArr[i] = Math.max(M - prices.get(i), backArr[i + 1]);

            M = Math.max(prices.get(i), M);

        }

        frontArr[0] = 0;

        backArr[n - 1] = 0;

        int ans = 0; 

        for (int i = 0; i < n - 1; i++)

        {

            ans = Math.max(frontArr[i] + backArr[i + 1], ans);

        }

        ans = Math.max(ans, frontArr[n - 1]);

        return ans;

    }

}
