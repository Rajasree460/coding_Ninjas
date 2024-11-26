import java.util.*; 
import java.io.*; 

public class Solution {
    public static ArrayList<Integer> sqsorted(ArrayList<Integer> arr) {
        // Create a new list to store squared values
        ArrayList<Integer> squaredList = new ArrayList<>();
        
        // Square each element and add to the new list
        for (int num : arr) {
            squaredList.add(num * num);
        }
        
        // Sort the squared list
        Collections.sort(squaredList);
        
        // Return the sorted list
        return squaredList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Number of test cases
        int t = sc.nextInt();
        
        while (t-- > 0) {
            // Number of elements in the array
            int n = sc.nextInt();
            
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            
            // Get the sorted squares list
            ArrayList<Integer> result = sqsorted(arr);
            
            // Print the result
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
