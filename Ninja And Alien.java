import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
  public static String alienOrder(ArrayList < String > words, int n) {
    //    Write your code here.

    // List<List<Integer>> adj = new ArrayList<>();
    Map < Character, Set < Character >> adj = new HashMap < > ();
    Map < Character, Integer > inDeg = new HashMap < > ();

    for (String wrd: words) {
      for (char c: wrd.toCharArray()) {
        inDeg.putIfAbsent(c, 0);
        adj.putIfAbsent(c, new HashSet < > ());
      }
    }

    for (int i = 0; i < n - 1; i++) {
      String s1 = words.get(i);
      String s2 = words.get(i + 1);

      int min = Math.min(s1.length(), s2.length());
      for (int c = 0; c < min; c++) {
        if (s1.charAt(c) != s2.charAt(c)) {
          char u = s1.charAt(c);
          char v = s2.charAt(c);
          // adj.putIfAbsent(u,new HashSet<>());
          if (!adj.get(u).contains(v)) {
            adj.get(u).add(v);
            inDeg.put(v, inDeg.get(v) + 1);
          }
          break;
        }
      }
    }

    PriorityQueue < Character > q = new PriorityQueue < > ();

    for (char ch: inDeg.keySet()) {
      if (inDeg.get(ch) == 0)
        q.add(ch);
    }

    StringBuilder s = new StringBuilder();

    while (!q.isEmpty()) {

      int len = q.size();

      for (int i = 0; i < len; i++) {

        char node = q.poll();
        s.append(node);

        if (adj.containsKey(node))
          for (char nv: adj.get(node)) {

            inDeg.put(nv, inDeg.get(nv) - 1);

            if (inDeg.get(nv) == 0) {
              q.add(nv);
            }
          }

      }
    }

    if (inDeg.size() > s.length()) {
      return "";
    }

    return s.toString();
  }

}
