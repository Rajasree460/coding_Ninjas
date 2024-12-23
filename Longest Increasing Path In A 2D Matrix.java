import java.util.*;

public class Solution {

   public static int longestIncreasingPath(ArrayList<ArrayList<Integer>> grid, int n, int m) {
       Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
       ArrayList<ArrayList<Integer>> indegree = new ArrayList<>(n);

       int[] delta = {-1, 0, +1, 0, -1};

       for (int i = 0; i < n; i++) {
           indegree.add(new ArrayList<>(Collections.nCopies(m, 0)));
       }

       for (int row = 0; row < n; row++) {
           for (int col = 0; col < m; col++) {
               for (int k = 0; k < 4; k++) {
                   int nrow = row + delta[k];
                   int ncol = col + delta[k + 1];

                   if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid.get(row).get(col) < grid.get(nrow).get(ncol)) {
                       indegree.get(nrow).set(ncol, indegree.get(nrow).get(ncol) + 1);
                   }
               }
           }
       }

       for (int row = 0; row < n; row++) {
           for (int col = 0; col < m; col++) {
               if (indegree.get(row).get(col) == 0) {
                   q.add(new Pair<>(new Pair<>(row, col), 1));
               }
           }
       }

       int maxPath = 1;

       while (!q.isEmpty()) {
           int row = q.peek().getKey().getKey();
           int col = q.peek().getKey().getValue();
           int pathDist = q.peek().getValue();
           q.poll();
           maxPath = Math.max(maxPath, pathDist);

           for (int k = 0; k < 4; k++) {
               int nrow = row + delta[k];
               int ncol = col + delta[k + 1];

               if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid.get(row).get(col) < grid.get(nrow).get(ncol)) {
                   indegree.get(nrow).set(ncol, indegree.get(nrow).get(ncol) - 1);
                   if (indegree.get(nrow).get(ncol) == 0) {
                       q.add(new Pair<>(new Pair<>(nrow, ncol), pathDist + 1));
                   }
               }
           }
       }

       return maxPath;
   }

   public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
       ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(9, 9, 4));
       ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(6, 6, 8));
       ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(2, 1, 1));
       grid.add(row1);
       grid.add(row2);
       grid.add(row3);

       int n = 3; // Number of rows
       int m = 3; // Number of columns

       System.out.println(longestIncreasingPath(grid, n, m)); // Output should be 4
   }

}

class Pair<K, V> {
   private final K key;
   private final V value;

   public Pair(K key, V value) {
       this.key = key;
       this.value = value;
   }

   public K getKey() {
       return key;
   }

   public V getValue() {
       return value;
   }
}
 
