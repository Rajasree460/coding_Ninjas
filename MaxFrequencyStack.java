import java.util.*;

import java.io.*;

 

public class FrequencyStack {

    HashMap<Integer, Integer> freq;

    HashMap<Integer, Stack<Integer>> map;

    int maxFreq;

 

    FrequencyStack() {

        maxFreq = 0;

        freq = new HashMap<>();

        map = new HashMap<>();

    }

 

    void push(int element) {

        if(!freq.containsKey(element)){

            freq.put(element, 1);

        }else{

            freq.put(element, freq.get(element)+1);

        }

        if(maxFreq < freq.get(element)){

            maxFreq = freq.get(element);

        }

        map.computeIfAbsent(freq.get(element), k -> new Stack<>()).push(element);

    }

 

    int pop() {

        if(maxFreq == 0){

            return -1;

        }

 

        int x = map.get(maxFreq).pop();

        freq.put(x, freq.get(x) -1);

        if (map.get(maxFreq).isEmpty())

        {

            maxFreq--;

        }

 

        return x;

    }

}
