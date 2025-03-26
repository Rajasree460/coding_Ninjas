import  java.util.*;

 

public class Solution {

  public static String permutationExist(String str1, String str2, int n, int m) {

    if (n > m) {

      return "No"; // String 1 cannot be a permutation of String 2 if it's longer

    }

 

    int[] count1 = new int[26];

    for (char c : str1.toCharArray()) {

      count1[c - 'a']++;

    }

 

    int[] count2 = new int[26];

    int i = 0;

    int windowSize = n;

 

    while (i < windowSize && i < m) {

      count2[str2.charAt(i) - 'a']++;

      i++;

    }

 

    if (Arrays.equals(count1, count2)) {

      return "Yes";

    }

 

    while (i < m) {

      char newChar = str2.charAt(i);

      count2[newChar - 'a']++;

 

      char oldChar = str2.charAt(i - windowSize);

      count2[oldChar - 'a']--;

 

      i++;

 

      if (Arrays.equals(count1, count2)) {

        return "Yes";

      }

    }

 

    return "No";

  }

}
