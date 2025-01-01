import java.util.ArrayList;

import java.util.HashMap;

import java.util.SortedMap;

import java.util.SortedSet;

import java.util.TreeMap;

import java.util.TreeSet;

import java.util.Vector;

 

public class Solution {

    public static ArrayList<String> stringQueries(ArrayList<ArrayList<String>> queries) {

        // Write your code here.

        ArrayList<String> ans = new ArrayList<>();

        SortedMap<Integer, SortedSet<String>> countMap = new TreeMap<>();

        HashMap<String, Integer> mapping = new HashMap<>();

        for(int i = 0; i < queries.size(); i++){

            if(queries.get(i).get(0).equals("Add")){

                int val = 1;

                if(mapping.containsKey(queries.get(i).get(1))){

                    val = mapping.get(queries.get(i).get(1));

                    countMap.get(val).remove(queries.get(i).get(1));

                    if(countMap.get(val).size() == 0){

                        countMap.remove(val);

                    }

                    val++;

                }

                if(!countMap.containsKey(val)){

                    countMap.put(val, new TreeSet<>());

                }

                countMap.get(val).add(queries.get(i).get(1));

                mapping.put(queries.get(i).get(1),val);

            }else if(queries.get(i).get(0).equals("Rem")){

                int val = -1;

                if(mapping.containsKey(queries.get(i).get(1))){

                    val = mapping.get(queries.get(i).get(1));

                    countMap.get(val).remove(queries.get(i).get(1));

                    if(countMap.get(val).size() == 0){

                        countMap.remove(val);

                    }

                    mapping.put(queries.get(i).get(1),val-1);

                    val--;

                }

                if(val == 0){

                    mapping.remove(queries.get(i).get(1));

                }else{

                    if(!countMap.containsKey(val)){

                        countMap.put(val, new TreeSet<>());

                    }

                    countMap.get(val).add(queries.get(i).get(1));

                }

            }else if(queries.get(i).get(0).equals("GetMaxKey")){

                ans.add(countMap.get(countMap.lastKey()).first());

            }else if(queries.get(i).get(0).equals("GetMinKey")){

                ans.add(countMap.get(countMap.firstKey()).first());

            }

        }

        return ans;

    }

}
