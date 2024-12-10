public class Solution {
	
	public static int LCS(String A, String B, String C, int n, int m, int k) {
		// Write your code here
		// code,coding,codingninjas
		int[][][] dp=new int[n+1][m+1][k+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				for(int l=0;l<=k;l++){
			dp[i][j][l]=-1;
		}
		}
		}
		return f(A,B,C,n,m,k,dp);	
	}
	static int f(String A, String B, String C, int n, int m, int k,int[][][]dp){
		if(n==0 || m==0 || k==0){
			return 0;
		}
		if (dp[n][m][k]!=-1) return dp[n][m][k];
		if(A.charAt(n-1)==B.charAt(m-1) && C.charAt(k-1)==B.charAt(m-1)){
			return dp[n][m][k]= 1+f(A, B, C, n-1, m-1, k-1,dp);
		}else{
			dp[n][m][k] = Math.max(f(A, B, C, n-1, m, k,dp),
		 Math.max(f(A, B, C, n, m-1, k,dp), 
		 f(A, B, C, n, m, k-1,dp)));

		}
		return dp[n][m][k];
	}


}
