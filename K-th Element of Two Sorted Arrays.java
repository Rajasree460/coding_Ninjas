import java.util.ArrayList;

public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        int first = 0;
        int second = 0;
        int count = 0;
        while (first < n && second < m) {
            if (arr1.get(first) < arr2.get(second)) {
                count++;
                if (count == k) {
                    return arr1.get(first);
                }
                first++;
            }
            else {
                count++;
                if (count == k)
                    return arr2.get(second);
                second++;
            }
        }
        while (first < n) {
            count++;
            if (count == k)
                return arr1.get(first);
            first++;
        }
        while (second < m) {
            count++;
            if (count == k)
                return arr2.get(second);
            second++;
        }
        return 0;
    }
}
