import java.util.*;

public class Solution {

    public static boolean isValid(int l,int r,String str1,String str2){

        int s=0;

        for(int i=l;i<=r;i++){

            if(str1.charAt(i)==str2.charAt(s)){

                s++;

            }

        }

        if(s<str2.length()){

            return false;

        }

        return true;

    }

    

    public static String minWindow(String S, String T) {

         int idx=-1;

       int cnt=0;

       int minLen=S.length()+1;

       int l=0;

       HashMap<Character,Integer> map=new HashMap<>();

       for(int i=0;i<T.length();i++){

           map.put(T.charAt(i),map.getOrDefault(T.charAt(i),0)+1);

       }

       

       for(int r=0;r<S.length();r++){

           if(map.containsKey(S.charAt(r))){

               if(map.get(S.charAt(r))>0){

                   cnt++;

               }

               map.put(S.charAt(r),map.get(S.charAt(r))-1);

           }

           while(cnt==T.length()){

               if(r-l+1<minLen && isValid(l,r,S,T)){

                   minLen=r-l+1;

                   idx=l;

               }

               if(map.containsKey(S.charAt(l))){

                  if(map.get(S.charAt(l))>=0){

                      cnt--;

                  } 

                  map.put(S.charAt(l),map.get(S.charAt(l))+1);

               }

               l++;

           }

       }

       

       return idx==-1?"":S.substring(idx,idx+minLen);

 

        

        

    }

}
