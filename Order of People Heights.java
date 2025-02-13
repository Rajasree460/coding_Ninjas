import java.util.*;
public class Solution {
 public static ArrayList<Integer> findOrder(ArrayList<Integer> height, ArrayList<Integer> infront) {
        // Write your code here.
        int n=height.size();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
          arr[i][0]=height.get(i);
          arr[i][1]=infront.get(i);
        }
        Arrays.sort(arr,(x,y)->y[0]-x[0]);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] a:arr) ans.add(a[1],a[0]);
        return ans;
    }
}
