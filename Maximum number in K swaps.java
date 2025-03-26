public class Solution {
    public static String findMax(String str, int k) {
        // Convert string to character array
        char[] num = str.toCharArray();
        String[] collector = {str};
        
        // Start swapping
        doSwap(num, k, 0, collector);
        
        return collector[0];
    }

    private static void doSwap(char[] num, int k, int i, String[] collector) {
        int n = num.length;
        
        // Base case
        if (k == 0 || i == n) {
            String newStr = new String(num);
            if (collector[0].compareTo(newStr) < 0) {
                collector[0] = newStr;
            }
            return;
        }

        // Find the maximum character to swap
        char maxCh = num[i];
        for (int j = i + 1; j <= n - 1; j++) {
            if (num[j] > maxCh) {
                maxCh = num[j];
            }
        }

        // Swap only if a larger character is found
        if (maxCh != num[i]) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (maxCh == num[j]) {
                    swap(num, i, j);
                    doSwap(num, k - 1, i + 1, collector);
                    swap(num, i, j);  // Backtrack
                }
            }
        } else {
            doSwap(num, k, i + 1, collector);
        }
    }

    private static void swap(char[] num, int i, int j) {
        char ch = num[i];
        num[i] = num[j];
        num[j] = ch;
    }
}
