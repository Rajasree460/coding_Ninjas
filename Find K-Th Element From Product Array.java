import java.util.*;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static int kthSmallest(ArrayList<Integer> arr, int k){

        int n = arr.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = arr.get(i) * arr.get(j);
                if (pq.size() < k) {
                    pq.add(product);
                } else if (product < pq.peek()) {
                    pq.poll();
                    pq.add(product);
                }
            }
        }
        if(pq.size()<k) return -1;
        return pq.peek();
    }

	/*
	public static int kthSmallest(ArrayList<Integer> arr, int k) 
	{
		//Write your code here

		ArrayList<Integer> productArr = new ArrayList<>();

		for(int i = 0 ;i< arr.size() ; i++){
			for(int j = i+1 ; j<arr.size() ; j++){
				if(i!=j){
					int product = arr.get(i)*arr.get(j);
					productArr.add(product);
				}
			}
		}
		Collections.sort(productArr);
		
		if (k > 0 && k <= productArr.size()) {
            return productArr.get(k - 1);
        }

		return -1;

		
	}
	
	*/
}
