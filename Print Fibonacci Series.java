public class Solution {
    public static int[] generateFibonacciNumbers(int n) {
        // Array to store the Fibonacci numbers
        int[] fibonacci = new int[n];
        
        // Base cases
        if (n >= 1) {
            fibonacci[0] = 0; // First Fibonacci number
        }
        if (n >= 2) {
            fibonacci[1] = 1; // Second Fibonacci number
        }
        
        // Calculate the rest of the Fibonacci sequence
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        
        return fibonacci; // Return the generated sequence
    }
    
}
