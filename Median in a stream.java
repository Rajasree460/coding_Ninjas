import java.util.*;

public class Solution {

    static Vector<Integer> ans;

    static void insertNew(int val)

    {

        if(ans.size()==0)

        {

            ans.add(val);

            return;

        }

        int index = -1;

        int s = 0;

        int e = ans.size()-1;

        while(s<=e)

        {

            int mid = (s+e)/2;

            if(ans.get(mid)>val)

            {

                e = mid-1;

                index = mid;

            }

            else

            {

                s = mid+1;

            }

        }

        if(index!=-1)

        {

            ans.add(index,val);

            return;

        }

        ans.add(val);

    }

    static void printVec()

    {

        for(int i=0;i<ans.size();i++)

        {

            System.out.print(ans.get(i)+" ");

        }

        System.out.println();

    }

    public static int[] findMedian(int[] arr, int n) {

        int[] result = new int[n];

        ans = new Vector<>();;

        for (int i = 0; i < n; i++) {

            insertNew(arr[i]);

            int size = ans.size();

            if (size == 1) {

                result[i] = ans.get(0);

            } else if (size % 2 == 1) {

                result[i] = ans.get(size / 2);

            } else {

                result[i] = (ans.get(size / 2) + ans.get(size / 2 - 1)) / 2;

            }

        }

        return result;

    }

}
