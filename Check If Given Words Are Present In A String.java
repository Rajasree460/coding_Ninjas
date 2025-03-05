import java.util.ArrayList;

 

public class Solution 

{

    public static boolean[] checkWordsInString(String s, int n, ArrayList<String> wordList) 

    {

        boolean[] ans = new boolean[n];

 

        for (int i = 0; i < n; i++) 

        {

            int k = s.indexOf(wordList.get(i));

 

            if (k != -1)

                ans[i] = true;

            else

                ans[i] = false;

        }

 

        return ans;

    }

}

 
