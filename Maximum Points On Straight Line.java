import java.util.*;
public class Solution {
    public static int maxPointsOnLine(int[][] points, int n) {
        int result = 0;
        Map<Double,Integer> map;
        for(int i = 0; i < n; i++){
            map = new HashMap<>();
            for(int j = 0; j <n; j++){
                if(i == j) continue;
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];
                double theta = Math.atan2(dy, dx);
                map.put(theta, map.getOrDefault(theta, 0)+1);
            }
            result = Math.max(result,Collections.max(map.values())+1);
        }
        return result;
    }
}
