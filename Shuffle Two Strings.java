import java.util.* ;
import java.io.*; 
public class Solution {
	public static boolean isInterleave(String a, String b, String c) {
		if(c.length() != (a.length() + b.length())) return false;
		// dp solution
		Map<String, Boolean> m = new HashMap<>();
		return helper(a, b, c, 0 , 0 , 0, m);
	}

	public static boolean helper(String a, String b, String c, int i, int j, int k, Map<String, Boolean> map ) {
		int m = a.length(), n = b.length(), p = c.length();
		if(k == p) return true;


		if(map.containsKey(i + " " + j + " " + k)) return map.get(i + " " + j + " " + k);
		boolean ans = false;

		if(k < p && i < m && j < n && c.charAt(k) == a.charAt(i) && c.charAt(k) == b.charAt(j)) {

			ans = ans || helper(a, b, c, i+1 , j , k+1, map) || helper(a, b, c, i , j+1 , k+1, map);

		} else if(k < p && i < m &&  c.charAt(k) == a.charAt(i)) {

			ans = ans ||  helper(a, b, c, i+1 , j , k+1, map);

		} else if(k < p && j < n && c.charAt(k) == b.charAt(j)) {

			ans = ans || helper(a, b, c, i , j+1 , k+1, map);

		} else {
			ans = ans || false;
		}

		map.put(i + " " + j + " " + k, ans);
		return ans;

	}
}
