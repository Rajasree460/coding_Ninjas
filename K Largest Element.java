import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int T = sc.nextInt();

        while (T-- > 0) {
            // Read the size of the array and the value of K
            int N = sc.nextInt();
            int K = sc.nextInt();

            // Read the array elements
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // Find the K largest elements
            int[] result = Klargest(arr, K, N);

            // Print the result
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static int[] Klargest(int[] arr, int K, int N) {
        // Min-heap to store the K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : arr) {
            minHeap.add(num);

            // If heap size exceeds K, remove the smallest element
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        // Extract elements from the heap into an array
        int[] result = new int[K];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        // Sort the result in non-decreasing order
        Arrays.sort(result);

        return result;
    }
}
