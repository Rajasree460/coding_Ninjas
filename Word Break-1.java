import java.util.*;
public class Solution {
    public static List<String> ans; 
    public static List< String > getAllValidSentences(String s, String []dict) {
        //  write your code here.


        ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        for(String ele:dict){
            set.add(ele);
        }
       helper(s, s.length(), set, 0, new ArrayList<>());
        return ans;
    }


    public static void helper(String s, int n, HashSet<String> set, int ind, ArrayList<String> list){


        if(ind>=n){
            // ans=true;
            String temp="";
            for(String ele: list){
                temp=temp+ele+" ";
            }
            ans.add(temp);
        }


        for(int i=ind;i<n;i++){
            if(set.contains(s.substring(ind, i+1))){
                list.add(s.substring(ind, i+1));
                helper(s, n, set, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
