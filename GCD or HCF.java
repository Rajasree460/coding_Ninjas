public class Solution {
    public static int calcGCD(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m; // Remainder of n divided by m
            n = temp;  // Assign smaller number to n
        }
        return n; // n is the GCD
    }
}
