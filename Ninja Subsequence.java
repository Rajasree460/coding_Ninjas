
import java.util.* ;
import java.io.*; 
public class Solution {

  public static String ninjaSubsequence(int n,String s, int k) {
    
    if(!isRegular(s)){
      if(k == 1) return s;
      else return "-1";
    }
    else{
      for(int i = 0; i < n; i++){
        int j = i;
        while(j < n && s.charAt(j) == s.charAt(i))  
          j++;
        if(s.charAt(i) == ')'){
          k--;
          if(k == 0){
            String ans = s.substring(0, i) + s.substring(i + 1);
            return ans;
          }
        }
        i = j - 1;
      }
      for(int i = n - 1; i >= 0; i--){
        int j = i;
        while(j >= 0 && s.charAt(j) == s.charAt(i))
          j--;
          if(s.charAt(i) == '('){
            k--;
            if(k == 0){
              String ans = s.substring(0, i) + s.substring(i + 1);
              return ans;
            }
          }
          i = j + 1;
      }
    }
    return "-1";
  }
  private static boolean isRegular(String s){
    int count = 0;
    for(char c: s.toCharArray()){
      if(c == '(') count++;
      else if(c == ')'){
        if(count == 0) return false;
        count--;
      }
    }
    return count == 0;
  }
}
