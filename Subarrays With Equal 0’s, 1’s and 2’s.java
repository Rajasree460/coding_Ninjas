import java.util.*;

import java.io.*;

 

public class Solution {

    public static int countSubarrays(int n, int[] arr) {

        if (n < 3)

            return 0;

        int ans = 0;

        int c0 = 0, c1 = 0, c2 = 0;

        String key = (c2-c1) + "#" + (c1-c0);

        HashMap<String, Integer> map = new HashMap<>();

        map.put(key, 1);

        for(int num : arr){

            if(num == 0)

                c0++;

            else if(num == 1)

                c1++;

            else

                c2++;

            key = (c2-c1) + "#" + (c1-c0);

            if(map.containsKey(key)){

                ans += map.get(key);

                map.put(key, map.get(key)+1);

            }else{

                map.put(key, 1);

            }

        }

        return ans;

    }

}
