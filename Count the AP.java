import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static int countAP(int n, int[] A) {
        
        // Write your Code here
        return getCount(n,A , -1, Integer.MIN_VALUE, 0, 0);
    }
    public static int getCount(int n ,int [] a ,int prevIdx , int prevDiff,int idx,int cnt){
        if(idx == n) return cnt >= 3 ? 1 : 0;
        int count = cnt >= 3 ? 1 : 0 ;
        for(int i = idx ; i < n ; i++){
            if(prevIdx == -1){
                count += getCount(n, a,i,prevDiff, i+1, cnt+1);
            }else{
                if(prevDiff == Integer.MIN_VALUE){
                    count += getCount(n, a, i,a[i] - a[prevIdx], i+1, cnt+1);
                }else{
                    if(a[prevIdx] + prevDiff == a[i]){
                        count += getCount(n, a, i,prevDiff, i+1, cnt+1);
                    }
                }
            }
        }
        return count;
    }
}
