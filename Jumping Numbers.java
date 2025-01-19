import java.util.* ;
import java.io.*; 
// Tc-O(K) where k is number of Jumping Numbers smaller than or equal to x
// sc- o(1)
public class Solution {
	public static List<Integer> findJumpingNumbers(int n) {
		// Write your code here.
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for(int i = 1; i <=9 && i <=n; i++){
			bfs(i,n,res);
		}
		Collections.sort(res);
		return res;
	}
	public static void bfs(int number , int n, List<Integer> res){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(number);
		while(!queue.isEmpty()){
			int num = queue.poll();
			if(num <= n){
				res.add(num);
				int last_digit = num % 10;
				if(last_digit != 0){
					queue.add (num * 10 + (last_digit - 1));
				}
				if(last_digit != 9){
				queue.add (num * 10 + (last_digit + 1));
				}
			}
		}
	} 
	
}
