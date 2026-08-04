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
List<Integer> arr;
    public List<Integer> postorderTraversal(TreeNode root) {
        arr=new ArrayList<>();
        dfs(root);
        return arr;
    }
        void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        arr.add(root.val);
    }
}