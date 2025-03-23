import java.util.ArrayList;

public class Solution {

    public static int bs(int min, ArrayList<Integer> a){

        int div=1,curr=0;

        for(int i:a){

          if(curr+i>min){

            curr=i;

            div++;

          }else curr+=i;

        }

        return div;

    }

    public static int splitArray(ArrayList<Integer> array, int k) {

        // Write your code here.

        int l=array.get(0),r=0;

        for(int i:array){

          l=Math.max(l,i);

          r+=i;

        }

        while(l<=r){

          int mid=(l+r)/2;

          int div=bs(mid,array);

          if(div==k) r=mid-1;

          else if(div>k) l=mid+1;

          else r=mid-1;

        }

        return l;

    }

}
