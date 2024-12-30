#include <bits/stdc++.h> 
int maxSum(int k, vector<vector<int>> &mat)
{
    int rows = mat.size();
    int cols = mat[0].size();
    int result = INT_MIN;

    for (int left = 0; left < cols; ++left)
    {
        // Initialize an array to store cumulative sums for each row in the submatrix
        vector<int> temp(rows, 0);

        for (int right = left; right < cols; ++right)
        {
            // Update the cumulative sums for each row
            for (int i = 0; i < rows; ++i)
            {
                temp[i] += mat[i][right];
            }

            // Find the maximum sum subarray in the current row cumulative sums
            int currSum = 0;
            set<int> prefixSums;
            prefixSums.insert(0);

            for (int i = 0; i < rows; ++i)
            {
                currSum += temp[i];
                auto it = prefixSums.lower_bound(currSum - k);

                if (it != prefixSums.end())
                {
                    result = max(result, currSum - *it);
                }

                prefixSums.insert(currSum);
            }
        }
    }

    return result;
}
