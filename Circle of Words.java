import java.util.* ;

import java.io.*; 

public class Solution{

    public static boolean circleOfWords(ArrayList<String> words){

        // Write your code here.

        List<Character> l1 = new ArrayList<>();

        List<Character> l2 = new ArrayList<>();

        for(int i=0;i<words.size();i+=1){

            String s1=words.get(i);

            char c1=s1.charAt(0);

            char c2=s1.charAt(s1.length()-1);

            l1.add(c1);

            l2.add(c2);

        }

        Collections.sort(l1);

        Collections.sort(l2);

 

        return l1.equals(l2);

    }

}
