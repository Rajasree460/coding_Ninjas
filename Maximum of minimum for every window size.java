import java.util.* ;

import java.io.*; 

import java.lang.Math;

public class Solution {

    public static int[] maxMinWindow(int[] arr, int n) {

        int[] ans = new int[n];

        for(int i=0;i<n;i++) {

            ans[i] = Integer.MIN_VALUE;

        }

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++) {

            while(!st.empty() && arr[st.peek()] >= arr[i]) {

                int ele = st.peek();st.pop();

                int nse = i;int pse = st.empty() ? -1 : st.peek();

                int length = nse - pse - 1;

                ans[length-1] = Math.max(ans[length-1], arr[ele]); 

            }

            st.push(i);

        }

        while(!st.empty()) {

            int ele = st.peek();st.pop();

            int nse = n;int pse = st.empty() ? -1 : st.peek();

            int length = nse-pse-1;

            ans[length-1] = Math.max(ans[length-1], arr[ele]);

        } 

        for (int i = n - 2; i >= 0; i--) 

        {

            ans[i] = Math.max(ans[i], ans[i + 1]);

        }

        return ans;

    }

}
