import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    private static ArrayList<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int it : adj.get(i)) inDegree[it]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) if(inDegree[i] == 0) q.offer(i);

        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int adjNode : adj.get(node)) {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        return topo;
    }
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < dictionary.length-1; i++) {
            String str1 = dictionary[i];
            String str2 = dictionary[i+1];

            int len = Math.min(str1.length(), str2.length());
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }

        ArrayList<Integer> topo = topoSort(k, adj);
        String ans = "";
        for (int it : topo) ans += (char)(it + (int)('a'));

        return ans;
        
    }
}
