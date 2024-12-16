/*
    Time Complexity: O(N*K)
    Space Complexity: O(N)

    Where N is the size of the array and K is the given integer.
*/

#include<stack>
#include<cmath>

#define MAX pow(2, 30) - 1

int subarrayMaximum(vector<int> &arr, int k){

    int n = arr.size();

    // Create two arrays two store the values.
    vector<int> currArr(n, MAX);
    vector<int> nextArr(n, 0);

    for(int split = 0; split < k; split++){

        // Intitialise empty stack.
        stack<int> stack;

        // We will start from split.
        // It's because we need minimum of X elements to form x more subarrays.
        for(int i = split; i < n; i++){

            // Update the next subarray's split.
            if(i != 0){
                nextArr[i] = currArr[i - 1] + arr[i];
            }
            else{
                nextArr[i] = arr[i];
            }

            // Update the values from the stack.
            // Arr[stack[-1]] will be last number larger than arr[i].
            while(stack.size() > 0 && arr[stack.top()] <= arr[i]){
                int j = stack.top();
                stack.pop();
                nextArr[i] = min(nextArr[i], nextArr[j] - arr[j] + arr[i]);
            }

            if(stack.size() > 0){
                nextArr[i] = min(nextArr[i], nextArr[stack.top()]);
            }

            // Insert current split index in the stack.
            stack.push(i);
        }

        // Swap the arrays.
        swap(currArr, nextArr);
    }

    return currArr.back();
}
