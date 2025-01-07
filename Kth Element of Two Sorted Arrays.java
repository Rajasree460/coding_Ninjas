import java.io.*;

import java.util.*;

public class Solution {

    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {

    int first =0;

    int second=0;

    int count=0;

       while(first<m&&second<n){

            if(row1[first]<row2[second]){

                count++;

                if(count==k){

                return row1[first];}

                first++;

            }

            else{

                count++;

                if(count==k)

                return row2[second];

                second++;

            }

        }

        while(first<m){

                count++;

                if(count==k)

                return row1[first];

                first++;

            }  

          while(second<n){

                count++;

                if(count==k)

                return row2[second];

                second++;

            }

            return 0;

    }

}
