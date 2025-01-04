import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static double minCostToHireCandidates(ArrayList<Integer> skill, ArrayList<Integer> expectedSalary, int n, int m) {		
		// Write your code here.
        double candidates[][]=new double[n][2];
        for(int i=0;i<n;i++){
           candidates[i][0]=(double)expectedSalary.get(i)/skill.get(i);
           candidates[i][1]=(double) skill.get(i);
        }
        Arrays.sort(candidates,(x,y)->Double.compare(x[0],y[0]));
        Queue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        double ans=Double.MAX_VALUE, skillSum=0;
        for(double[] candidate: candidates){
           skillSum+=candidate[1];
           pq.add(candidate[1]);
           if(pq.size()>m) skillSum-=pq.poll();
           if(pq.size()==m) ans=Math.min(ans, candidate[0]*skillSum);
        }
        return ans;
	}
}
