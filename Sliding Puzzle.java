import java.util.*;

 

public class Solution {

    public static String swapString(String st, int i, int j) {

        char[] chars = st.toCharArray();

        char temp = chars[i];

        chars[i] = chars[j];

        chars[j] = temp;

        return new String(chars);

    }

 

    public static int slidingPuzzle(List<List<Integer>> board) {

        LinkedList<String> queue = new LinkedList<>();

        String target = "123450";

        StringBuilder sb = new StringBuilder();

        

        for (List<Integer> row : board) {

            for (Integer cell : row) {

                sb.append(cell);

            }

        }

        

        String initial = sb.toString();

        int[][] swapIndices = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {4, 2}};

        queue.addLast(initial);

        int level = 0;

        HashSet<String> visited = new HashSet<>();

        

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current = queue.removeFirst();

                if (current.equals(target)) return level;

                int idx = -1;

                for (int i = 0; i < current.length(); i++) {

                    if (current.charAt(i) == '0') {

                        idx = i;

                        break;

                    }

                }

                int[] swaps = swapIndices[idx];

                for (int i = 0; i < swaps.length; i++) {

                    String toAdd = swapString(current, idx, swaps[i]);

                    if (visited.contains(toAdd)) continue;

                    queue.addLast(toAdd);

                    visited.add(toAdd);

                }

            }

            level++;

        }

        return -1; 

    }

}
