import java.util.Arrays;

public class Solution 
{
	private static int [][] dp ;
	public static Boolean isMatch(String s, String p) {
		// Write your code here.
		dp = new int[s.length()+1][p.length()+1];
		for(int t[] : dp){
			Arrays.fill(t, -1);
		}
		return match(s, p, 0, 0);
	}
	public static boolean match(String s,String p ,int i,int j){
		if( i >= s.length() && j >= p.length()) return true;
		// if(i >= s.length() || j >= p.length()) return false;
		if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;
		if( j +1 < p.length() && p.charAt(j+1) == '*'){
			boolean check = match(s, p, i, j+2);
			if(i < s.length() && (p.charAt(j) =='.' || p.charAt(j) == s.charAt(i))){
				check |= match(s, p, i+1, j);
			}
			dp[i][j] = check ? 1 : 0;
			return check;
		}else{
			if( (j < p.length() && i < s.length()) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
				boolean temp =  match(s, p, i+1, j+1);
				dp[i][j] = temp ? 1 : 0;
				return temp;
			}
		}
		dp[i][j] = 0;
		return false;
	}
}

