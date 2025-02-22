import java.util.* ;

import java.io.*; 

public class Solution {

    public static int[] multiply(int[] a, int[] b, int n)

    {

        int[] result = new int[2 * n - 1];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                result[i + j] += a[i] * b[j];

            }

        }

        return result;

    }

}
