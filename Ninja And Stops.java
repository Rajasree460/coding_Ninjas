import java.util.*;
public class Solution {
	public static int minRefuelStops(int target, int startFuel, ArrayList<ArrayList<Integer>> stations) {
		// Write your code here.
        if(target<=startFuel) return 0;
        int i=0,stops=0,n=stations.size();
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        while(startFuel<target){
           while(i<n && stations.get(i).get(0)<=startFuel) pq.add(stations.get(i++).get(1));
           if(pq.isEmpty()) return -1;
           startFuel+=pq.poll();
           stops++;
        }
        return stops;
	}
}
