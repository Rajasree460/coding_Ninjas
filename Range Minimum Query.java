import java.util.*;

 

public class Solution {

    public static int[] rangeMinimumQuery(int s, int[] arr, int q, int[][] query) {

        SegmentTree st = new SegmentTree(arr);

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {

            result[i] = st.query(query[i][0], query[i][1]);

        }

        return result;

    }

}

  class SegmentTree {

 

        private static class Node {

            int data;

            int startInterval;

            int endInterval;

            Node left;

            Node right;

 

            public Node(int startInterval, int endInterval) {

                this.startInterval = startInterval;

                this.endInterval = endInterval;

            }

        }

 

        Node root;

 

        public SegmentTree(int[] arr) {

            this.root = constructTree(arr, 0, arr.length - 1);

        }

 

        private Node constructTree(int[] arr, int start, int end) {

            if (start == end) {

                Node leaf = new Node(start, end);

                leaf.data = arr[start];

                return leaf;

            }

 

            Node node = new Node(start, end);

 

            int mid = (start + end) / 2;

 

            node.left = this.constructTree(arr, start, mid);

            node.right = this.constructTree(arr, mid + 1, end);

 

            node.data = Math.min(node.left.data, node.right.data);

            return node;

        }

 

        public int query(int qsi, int qei) {

            return this.query(this.root, qsi, qei);

        }

 

        private int query(Node node, int qsi, int qei) {

            if (node.startInterval >= qsi && node.endInterval <= qei) {

                return node.data;

            } else if (node.startInterval > qei || node.endInterval < qsi) {

                return Integer.MAX_VALUE;

            } else {

                return Math.min(this.query(node.left, qsi, qei), this.query(node.right, qsi, qei));

            }

        }

    }

 
