/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    PriorityQueue<Integer> q;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        q=new PriorityQueue<>(Collections.reverseOrder());// max-heap 
        this.k=k;
        dfs(root);
        return q.peek();
    }

    void dfs(TreeNode root){
        if(root==null) return;
        q.add(root.val);// simply add to queue 
        if(q.size()>k){// if size exceeded by entering value then poll a greatest element from queue
            q.poll();
        }
        dfs(root.left);
        dfs(root.right);
    }
}
