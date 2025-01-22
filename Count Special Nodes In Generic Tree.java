import java.util.*;

 

public class Solution {

 

    public static void func(TreeNode<Integer> root, int k, Set<Integer> s1, int[] ans) {

        if (root == null || k > s1.size()) {

            k--;

            return;

        }

 

        if (k == s1.size()) ans[0]++;

 

        for (int i = 0; i < root.numChildren(); i++) {

            s1.add(root.getChild(i).data);

            func(root.getChild(i), k + 1, s1, ans);

            if (k != s1.size()) s1.remove(root.getChild(i).data);

        }

    }

 

    public static int countSpecialNodes(TreeNode<Integer> root) {

        Set<Integer> s1 = new HashSet<>();

        s1.add(root.data);

        int[] ans = {0};

 

        func(root, 1, s1, ans);

        return ans[0];

    }

}
