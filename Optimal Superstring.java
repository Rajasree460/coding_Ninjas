import java.util.*;
public class Solution {
    private static String[][] req;

    private static String merge(String a, String b) {
        int n = a.length();
        int m = b.length();
        int len = 1, idx = 0;

        while (len <= Math.min(n, m)) {
            if (a.substring(n - len).equals(b.substring(0, len))) {
                idx = len;
            }
            len++;
        }

        return b.substring(idx);
    }

    private static String solve(String[] words, int prev, int mask, int n, String[][] dp) {
        if (dp[prev][mask] != null) return dp[prev][mask];

        String res = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) continue;
            String temp = req[prev][i] + solve(words, i, mask | (1 << i), n, dp);
            if (temp.length() < minLen) {
                minLen = temp.length();
                res = temp;
            }
        }

        return dp[prev][mask] = res;
    }

    public static int optimalSuperstring(String[] words, int size) {
        int n = words.length;
        req = new String[n][n];
        String[][] dp = new String[n][1 << (n + 1)];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                req[i][j] = merge(words[i], words[j]);
            }
        }
        // System.out.println(Arrays.deepToString(req));
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int mask = 0;

        for (int i = 0; i < n; i++) {
            String temp = words[i] + solve(words, i, mask | (1 << i), n, dp);
            if (temp.length() < minLen) {
                minLen = temp.length();
                ans = temp;
            }
        }

        return ans.length();
    }
}
