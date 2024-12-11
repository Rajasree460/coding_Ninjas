import java.util.*;
public class Solution {
    public static int palindromePartitioning(String str) {
        // Write your code here
        return partition(str,0, str.length()-1,new HashMap<>());
    }
    public static int partition(String s,int l,int r,Map<String,Integer> memo){
      if(l>=r) return 0;
      String curr=l+"-"+r;
      if(memo.containsKey(curr)) return memo.get(curr);
      if(isPalin(s,l,r)){
        memo.put(curr,0); 
        return 0;
      }
      int cuts=(int)(1e9);
      for(int i=l;i<=r;i++){
          if(isPalin(s,l,i)){
            cuts=Math.min(cuts, 1+partition(s,i+1,r,memo));
          }
      }
      memo.put(curr,cuts);
      return cuts;
    }
    public static boolean isPalin(String s,int i,int j){
      while(i<j) if(s.charAt(i++)!= s.charAt(j--)) return false;
      return true;
    }
}
