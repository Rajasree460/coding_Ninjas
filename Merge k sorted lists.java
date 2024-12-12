import java.util.*;

public class Solution {

    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {

        PriorityQueue<LinkedListNode<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        int k = listArray.length;

        if (k == 0) {

            return null;

        }

        for (int i = 0; i < k; i++) {

            if (listArray[i] != null) {

                minHeap.add(listArray[i]);

            }

        }

        LinkedListNode<Integer> head = null, last = null;

        while (!minHeap.isEmpty()) {

            LinkedListNode<Integer> top = minHeap.poll();

            if (top.next != null) {

                minHeap.add(top.next);

            }

            if (head == null) {

                head = top;

                last = top;

            } else {

                last.next = top;

                last = top;

            }

        }

        return head;

    }

}
