import java.util.*; 

public class Solution {

    public static int countninja(ArrayList<Integer>pages,int pag)

    {

        int nin=1;

        int page=0;

        for(int i=0;i<pages.size();i++)

        {

            if(pages.get(i)+page<=pag)

            {

                page+=pages.get(i);

            }

            else

            {

                nin++;

                page=pages.get(i);

            }

        }

        return nin;

    }

    public static int allocateBooks(ArrayList<Integer> pages,int n ,int b) {

        if(b>n)return -1;

        int high=pages.stream().mapToInt(Integer::intValue).sum();

        int low=Collections.max(pages);

        while(low<=high)

        {

            int mid=(low+high)/2;

            if(countninja(pages,mid)>b)

            {

                low=mid+1;

            }

            else

            {

                high=mid-1;

            }

        }

        return low;

    }

}
