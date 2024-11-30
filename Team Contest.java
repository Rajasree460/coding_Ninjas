import java.util.Arrays;

public class Solution {
    public static int team(int[] skill, int n) {
        return mergeSortAndCount(skill, 0, n - 1);
    }

    private static int mergeSortAndCount(int[] skill, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        // Count pairs in left, right, and across the split
        int count = mergeSortAndCount(skill, left, mid) 
                  + mergeSortAndCount(skill, mid + 1, right)
                  + countPairs(skill, left, mid, right);

        // Merge the two sorted halves
        merge(skill, left, mid, right);

        return count;
    }

    private static int countPairs(int[] skill, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && skill[i] > 2L * skill[j]) { // 2L to handle overflow
                j++;
            }
            count += (j - mid - 1);
        }

        return count;
    }

    private static void merge(int[] skill, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Merge the two halves into temp
        while (i <= mid && j <= right) {
            if (skill[i] <= skill[j]) {
                temp[k++] = skill[i++];
            } else {
                temp[k++] = skill[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = skill[i++];
        }
        while (j <= right) {
            temp[k++] = skill[j++];
        }

        // Copy back to the original array
        System.arraycopy(temp, 0, skill, left, temp.length);
    }
}
