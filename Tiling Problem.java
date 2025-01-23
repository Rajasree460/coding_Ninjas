import java.util.*;

public class Solution {
	private static final int MOD = 1_000_000_007;
	private static long mat[][] = {{1,1},{1,0}} ;
	public static long numberOfWaysToTile(long n) {
		//Your code goes here
		long [][] ans = pow(mat, n+1);

		return (ans[0][1] % MOD)%MOD;
		
	}
	public static long[][] pow(long [][]mat ,long pow){
		if(pow == 0) return new long[][]{{1,0},{0,1}};
		long result[][] = pow(mat, pow/2);
		long mul[][] = multiply(result, result);
		if(pow%2 == 0){
			return mul;
		}
		return multiply(mul, mat);
	}

	public static long[][] multiply(long[][]a,long [][]b){
		long result [][] = new long[a.length][b[0].length];

		for(int l = 0 ; l < result.length ; l++){
			for(int k = 0 ; k < result[0].length ; k++){
				long res = 0;
				for(int i = 0 ; i < a[0].length;i++){
					res += (a[l][i] * b[i][k])%MOD ;
				}
				result[l][k] = res;
			}
		}
		return result;
	}
}
