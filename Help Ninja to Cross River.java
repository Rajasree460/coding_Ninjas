import java.util.*;

 

public class Solution {

    static ArrayList<ArrayList<Integer>> memo;

 

    public static boolean solve(ArrayList<Integer> safe, int index, int x, HashMap<Integer, Integer> myMap) {

        // If we reached the last safe unit.

        if (index == safe.size() - 1) {

            return true;

        }

 

        if (memo.get(index).get(x) != -1) {

            return memo.get(index).get(x) == 1;

        }

 

        int pos1 = safe.get(index) + x;

        int pos2 = safe.get(index) + x + 1;

        int pos3 = safe.get(index) + x - 1;

 

        // If pos1 is a safe unit.

        if (myMap.containsKey(pos1)) {

            if (solve(safe, myMap.get(pos1), x, myMap)) {

                memo.get(index).set(x, 1);

                return true;

            }

        }

 

        // If pos2 is a safe unit.

        if (myMap.containsKey(pos2)) {

            if (solve(safe, myMap.get(pos2), x + 1, myMap)) {

                memo.get(index).set(x, 1);

                return true;

            }

        }

 

        // Check if pos3 is a safe unit and x-1 is greater than 0.

        if (x - 1 > 0 && myMap.containsKey(pos3)) {

            if (solve(safe, myMap.get(pos3), x - 1, myMap)) {

                memo.get(index).set(x, 1);

                return true;

            }

        }

 

        // If none of the positions lead to the last safe unit, return false.

        memo.get(index).set(x, 0);

        return false;

    }

 

    public static boolean crossRiver(ArrayList<Integer> safe) {

        int n = safe.size();

 

        HashMap<Integer, Integer> myMap = new HashMap<>();

        memo = new ArrayList<>(n);

 

        for (int i = 0; i < n; i++) {

            memo.add(new ArrayList<>(Collections.nCopies(n + 1, -1)));

            myMap.put(safe.get(i), i);

        }

 

        // Checking for the first safe unit.

        if (safe.get(1) - safe.get(0) == 1) {

            return solve(safe, 1, 1, myMap);

        }

 

        return false;

    }

}

 
