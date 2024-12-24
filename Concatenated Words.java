import java.util.* ;
import java.io.*; 
public class Solution {
	public static String[] getConcatenatedWords(int n, String[] words) {
		// Write your code here.
		Set<String> set = new HashSet<>();
		for(String s:words) set.add(s);
		List<String> list = new ArrayList<>();
		for(String s : words){
			Set<String> temp = new HashSet<>(set);
			if(isPossible(s,temp)){
				list.add(s);
			}
		}
		return list.stream().toArray(String[]::new);
	}
	public static boolean isPossible(String s,Set<String> set){
		set.remove(s);
		if(set.isEmpty()) return false;
		for(int i = 1 ; i < s.length() ;i++){
			String pre = s.substring(0,i);
			String suf = s.substring(i);
			if(set.contains(pre) && (set.contains(suf) || isPossible(suf, set))) return true;
		}
		return false;
	}
	
}
