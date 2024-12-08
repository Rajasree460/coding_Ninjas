import java.util.*;

 

class Pair {

    

     String first;

     int second;

     Pair(String first,int second){

       this.first=first;

       this.second=second;

     }

}

 

public class Solution {

    public static int wordLadder(String begin, String end, ArrayList<String> dict) {

    

        Set < String > st = new HashSet <> (dict); 

        Queue<Pair> q=new LinkedList<>();



        q.add(new Pair(begin,1));

        st.remove(begin); 
 

        while(!q.isEmpty()){

          String word=q.peek().first;

          int steps=q.peek().second;

          q.remove();


            if (word.equals(end) == true) return steps;

 

    

          for(int i=0;i<word.length();i++){

            for(char ch='a';ch<='z';ch++){

              char replacecharArr[]=word.toCharArray();

              replacecharArr[i]=ch;

              String newWord=new String(replacecharArr);

 
               if(st.contains(newWord)){

                 st.remove(newWord);

                 q.add(new Pair(newWord, steps+1));

               }

            }

          }

        }


        return -1;

    }

}
