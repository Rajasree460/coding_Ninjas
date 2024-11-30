public class Solution {
    public static boolean isPalindrome(String str) {
        // Call the recursive helper function
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int left, int right) {
        // Base case: If the left index crosses the right index, it's a palindrome
        if (left >= right) {
            return true;
        }

        // Check if the characters at the current indices are equal
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursive call for the substring
        return isPalindromeHelper(str, left + 1, right - 1);
    }
}
