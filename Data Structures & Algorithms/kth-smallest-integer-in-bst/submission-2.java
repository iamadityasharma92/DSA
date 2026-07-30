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
    int k;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        // need to find the smallest 
        // priority -> explore left tree first as chances are high left side will contain smaller element 
        // store a count and decrease the count and return the element if count becomes zero
        res=0;
        this.k=k;

        find(root);
        return res;
    }
    void find(TreeNode root){
        if(root==null) return;

        find(root.left);
        k--;
        if(k==0){
            res=root.val;
        }
        find(root.right);
    }
}
