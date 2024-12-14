public class Solution {

    

    public static int[] subArray(int n, int K, int[] A) {

        

        int[] ans = new int[]{-1, -1, -1};

 

        int mx = 0;

        int curSum = 0;

 

        int[] W = new int[n - K + 1];

 

        for(int i = 0; i < n; i++)

        {   

            // Storing sum of 'K' elements using sliding window.

            curSum += A[i];

        

            if(i >= K)

            {

                curSum -= A[i - K];

            }

 

            if(i - K + 1 >= 0)

            {

                W[i - K + 1] = curSum;

            }

        }

 

        // Array to store left best index.

        int[] left = new int[n];

 

        int best = 0;

 

        for(int i = 0; i < W.length; i++)

        {

            if(W[i] > W[best])

            {

                best = i;

            }

            left[i] = best;

        }

 

        // Array to store right best index.

        int[] right = new int[n];

 

        best = W.length - 1;

 

        for(int i = W.length - 1; i >= 0; i--)

        {

            if(W[i] >= W[best])

            {

                best = i;

            }

            right[i] = best;

        }

 

        // Fixing j and finding best i and l.

        for(int j = K; j < W.length - K; j++)

        {

            int i = left[j - K];

            int l = right[j + K];

 

            curSum = W[i] + W[j] + W[l];

            if(ans[0] == -1 || curSum > mx)

            {

                mx = curSum;

                ans = new int[]{i, j, l};

            }

        }

 

        return ans;

    }

}
