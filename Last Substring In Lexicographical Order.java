public class Solution {

 

    public static String findLastSubstring(String str) {

        String substring = "";

 

        String maxi = "";

        for (int i = str.length() - 1; i >= 0; i--) {

            substring = str.charAt(i) + substring;

            if (maxi.compareTo(substring) < 0) {

                maxi = substring;

            }

        }

        return maxi;

   }

}
