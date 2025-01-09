import java.util.ArrayList;

public class Solution {

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {

        ArrayList<Integer> ans = new ArrayList<>();

        int n = queries.size();

        int x = arr.size();

        for(int i=0;i<n;i++){

            int maxXor = -1;

            for(int j=0;j<x;j++){

                if(arr.get(j)<=queries.get(i).get(1)){

                    int currentXor = queries.get(i).get(0)^arr.get(j);

                    maxXor = Math.max(maxXor, currentXor);

                }

            }

            ans.add(maxXor);

        }

        return ans;

    }

}
