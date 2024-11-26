import java.util.*;

public class Solution {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        // Handle cases where k >= n
        k = k % n;

        // Create a new list for the rotated array
        ArrayList<Integer> rotatedArray = new ArrayList<>();

        // Add the elements from index k to the end
        for (int i = k; i < n; i++) {
            rotatedArray.add(arr.get(i));
        }

        // Add the first k elements
        for (int i = 0; i < k; i++) {
            rotatedArray.add(arr.get(i));
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        int n = sc.nextInt();

        // Input array elements
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Input number of rotations
        int k = sc.nextInt();

        // Get the rotated array
        ArrayList<Integer> result = rotateArray(arr, k);

        // Print the rotated array
        for (int val : result) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
