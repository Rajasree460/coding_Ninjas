public class Solution {

 

    //Brute force

    public static double median(int[] arr1, int[] arr2) {

        int n=arr1.length;

        int m=arr2.length;

        int total = m+n;

        int l1=0,l2=0,r1=0,r2=0;

        // Binary Search

        int left = 0,right = n-1;

        double median = 0;

        while(left<=right){

            l1 = (left+right)/2;

            l2 =(total/2)-(l1+1)-1;

            r1 = l1+1;

            r2 = l2+1;

 

        if(arr1[l1]<=arr2[r2]&& arr2[l2]<=arr1[r1]){

                if(total%2==0){

                     median = (Math.max(arr1[l1], arr2[l2])+Math.min(arr1[r1], arr2[r2]))/2.0;

                }else{

                    median = Math.min(arr1[r1], arr2[r2]);

                }

               

                break;

            }

            if(arr1[l1]>arr2[r2]){

                right = l1-1;

            }else if(arr2[l2]>arr1[r1]){

               left = l1+1;

            }

        }

        return median;

        

 

    }

}
