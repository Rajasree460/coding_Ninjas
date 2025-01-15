public class Solution {            
	public static void printWellFormedParanthesis(int n){    	
		// Write your code here
        rec(n,0,0,"");
	}
	
    private static void rec(int n,int o,int c, String s){
        if(s.length()==2*n){
            System.out.println(s);
            return;
        }
        if(o<n) rec(n,o+1,c,s+'(');
        if(o>c) rec(n,o,c+1,s+')');
    }
}
