import java.util.* ;

import java.io.*; 

public class Solution {

    public static int minGroups(int[] arr, int n) {

    int[] groups = new int[1000];

    int numGroups = 0;

    for (int i = 0; i < n; ++i) {

        boolean placed = false;

        for (int j = 0; j < numGroups; ++j) {

            if (arr[i] >= groups[j]) {

                groups[j] = arr[i];

                placed = true;

                break;

            }

        }

        if (!placed) {

            groups[numGroups++] = arr[i];

        }

    } 

    return numGroups;

}

    public static int minimumSortedGroups(int n, int[] arr) {

        // Write your code here.

        return minGroups(arr, n);

    }

}
