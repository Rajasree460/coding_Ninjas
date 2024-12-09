import java.util.* ;

import java.io.*; 

public class Solution {

    public static String reArrangeString(String s) {

       Queue<Pair> pq=new PriorityQueue<>((x,y)->y.freq-x.freq);

       Map<Character,Integer> hm=new HashMap<>();

       for(char c:s.toCharArray()) hm.put(c,hm.getOrDefault(c,0)+1);;

       for(Map.Entry<Character,Integer> m:hm.entrySet()) pq.add(new Pair(m.getKey(), m.getValue()));

       StringBuilder sb=new StringBuilder();

       Pair p=pq.poll();

       sb.append(p.ca);

       p.freq--;

       while(!pq.isEmpty()){

         Pair curr=pq.poll();

         sb.append(curr.ca);

         curr.freq--;

         if(p.freq>0) pq.add(p);

         p=curr;

       }

       return (p.freq>0)?"not possible": sb.toString();

    }

}

class Pair{

  char ca;

  int freq;

  Pair(char ca,int freq){

    this.ca=ca;

    this.freq=freq;

  }

}
