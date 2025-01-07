import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		int sum =0;
		ArrayList<Integer> s = new ArrayList<>();

		for(int i=0;i<arr.length;i++){
				s.add(arr[i]);
				Collections.sort(s);
				findMedian(s);
		}
    
    }
	public static void findMedian(ArrayList<Integer> list)
	{
		int size = list.size();
		if(size==1){System.out.print(list.get(0)+" ");return;}
		if(size%2==0 ){
			//even
			int middle = size/2;
			int temp = list.get(middle) + list.get(middle-1);
			temp = (int)Math.ceil(temp/2);
			System.out.print(temp+" ");
			
		}
		else{
			//odd
			int val = (int) Math.ceil(size/2);
			System.out.print(list.get(val)+" ");

		}
	
	}


}
