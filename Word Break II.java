import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static void solve(String s, ArrayList<String> dictionary, ArrayList<String> ans ,String temp){
		// base case:
		if(s.length() == 0){
			temp.trim();
			ans.add(temp);
			return;
		}

		for( int i = 0; i<s.length(); i++){
			String left = s.substring(0,i+1);
			if(dictionary.contains(left)){
				solve(s.substring(i+1),dictionary,ans ,temp+left+" ");
			}
		}
	}
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
		ArrayList<String> ans = new ArrayList<String>();
		solve(s,dictionary,ans ,"");
		return ans;
	}
}
