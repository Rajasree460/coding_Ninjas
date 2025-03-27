public class Solution {
    public static long find(int s[],long p){
      long solvers=1,currSolve=0;
      for(int i=0;i<s.length;i++){
        if(currSolve+(long)s[i]<=p) currSolve+=(long)s[i];
        else{
          currSolve=(long)s[i];
          solvers++;
        }
      }
      return solvers;
    }
    public static long minimumRequiredTime(int subjects[], int k) {
        // Write your code here!
        long l=0,r=0;
        for(int i:subjects){
          if((long)i>l) l=(long)i;
          r+=(long)i;
        }
        while(l<=r){
          long mid=(l+r)/2;
          if(find(subjects,mid)<=(long)k) r=mid-1;
          else l=mid+1;
        }
        return l;
    }
}
