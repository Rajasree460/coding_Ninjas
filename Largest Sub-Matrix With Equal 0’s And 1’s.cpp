#include <bits/stdc++.h> 

//convert all 0's to -1 //then this problem reduces to Largest rectangular //sub-matrix whose sum is 0  

int largestSubArrayWithZeroSum(vector<int>& tmp) {

    int sum = 0, maxLength = 0;

    unordered_map<int, int> prefixSumIndex;

    for (int i = 0; i < tmp.size(); ++i) {

        sum += tmp[i];

        if (sum == 0) {

            maxLength = i + 1; // Entire array up to i has a sum of zero

        }

        if (prefixSumIndex.find(sum) != prefixSumIndex.end()) {

            maxLength = max(maxLength, i - prefixSumIndex[sum]);

        } else {

            prefixSumIndex[sum] = i;

        }

    }

    return maxLength;

}

 

int largestSubMatrix(int n, int m, vector<vector<int>>& arr) {

    int maxArea = 0;

 

    // Transform the matrix: Convert all 0s to -1s               //-------> main idea

    for (int i = 0; i < n; ++i) {

        for (int j = 0; j < m; ++j) {

            if (arr[i][j] == 0) {

                arr[i][j] = -1;

            }

        }

    }

 

    // Iterate over all pairs of rows

    for (int i = 0; i < n; ++i) {

        vector<int> temp(m, 0);

 

        for (int j = i; j < n; ++j) {

            for (int k = 0; k < m; ++k) {

                temp[k] += arr[j][k];

            }

 

            // Find the largest subarray with sum zero in the temp array

            int len = largestSubArrayWithZeroSum(temp);

            int area = len * (j - i + 1); // Calculate the area of the submatrix

 

            // Update the maximum area

            maxArea = max(maxArea, area);

        }

    }

 

    return maxArea;

}

   
