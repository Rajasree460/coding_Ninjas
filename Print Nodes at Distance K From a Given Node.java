import java.util.*;
public class Solution {
    public static void addParent(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> hm){
      if(root==null) return;
      hm.put(root,p);
      addParent(root.left,root,hm);
      addParent(root.right,root,hm);
    }
    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        // Write your code here.
        List<BinaryTreeNode<Integer>> al=new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent=new HashMap<>();
        Set<BinaryTreeNode<Integer>> vis=new HashSet<>();
        addParent(root,null,parent);
        q.add(target);
        vis.add(target);
        while(!q.isEmpty()){
         int n=q.size();
         for(int i=0;i<n;i++){
          BinaryTreeNode<Integer> curr=q.poll();
          if(K==0) al.add(curr);
          if(curr.left!=null && !vis.contains(curr.left)) {
              q.add(curr.left);
              vis.add(curr.left);
          }
          if(curr.right!=null && !vis.contains(curr.right)) {
              q.add(curr.right);
              vis.add(curr.right);
          }
          if(parent.get(curr)!=null && !vis.contains(parent.get(curr))){
              q.add(parent.get(curr));
              vis.add(parent.get(curr));
          }
          }
          K--;
          if(K<0) break;
        }
        return al;
    }
}
