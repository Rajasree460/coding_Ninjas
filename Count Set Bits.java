public class Solution 

{

    public static int CountBits(int x){

       int c=0;

        while(x!=0){

            if((x&1)==1){

               c++;

            }

            x=x>>1;

        } 

        return c;

    }

    public static int countSetBits(int n) 

    {

        int sum=0;

        for(int i=1;i<=n;i++){

           sum=sum+CountBits(i);

        }

        return sum%1000000007;

    }

}
