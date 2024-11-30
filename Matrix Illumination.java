import java.util.*;

public class Solution {

    public static ArrayList<Integer> isIlluminated(int n, int m, int[][] bulb, int q, int[][] query) {
        // Counters for row, column, and diagonal illuminations
        int[] rowIllumination = new int[n];
        int[] colIllumination = new int[n];
        int[] diag1Illumination = new int[2 * n];
        int[] diag2Illumination = new int[2 * n];
        
        // Set to keep track of active bulbs
        Set<String> activeBulbs = new HashSet<>();
        
        // Process the bulbs to initialize illumination
        for (int[] b : bulb) {
            int r = b[0];
            int c = b[1];
            String key = r + "," + c;
            if (!activeBulbs.contains(key)) {
                activeBulbs.add(key);
                rowIllumination[r]++;
                colIllumination[c]++;
                diag1Illumination[r - c + n]++;
                diag2Illumination[r + c]++;
            }
        }
        
        // Result to store query answers
        ArrayList<Integer> result = new ArrayList<>();
        
        // Directions for adjacent cells (including the cell itself)
        int[][] directions = {
            {0, 0}, {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };
        
        // Process each query
        for (int[] qPos : query) {
            int r = qPos[0];
            int c = qPos[1];
            
            // Check if the cell is illuminated
            if (rowIllumination[r] > 0 || colIllumination[c] > 0 || 
                diag1Illumination[r - c + n] > 0 || diag2Illumination[r + c] > 0) {
                result.add(1);
            } else {
                result.add(0);
            }
            
            // Turn off the bulb and its adjacent cells
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    String key = nr + "," + nc;
                    if (activeBulbs.contains(key)) {
                        activeBulbs.remove(key);
                        rowIllumination[nr]--;
                        colIllumination[nc]--;
                        diag1Illumination[nr - nc + n]--;
                        diag2Illumination[nr + nc]--;
                    }
                }
            }
        }
        
        return result;
    }
}
