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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        if(root.val<key)root.right=deleteNode(root.right,key);// look in right subtree
        else if(root.val>key)root.left=deleteNode(root.left,key);// look in right subtree
        else{
            if(root.right==null)return root.left;// if right tree null replace with left subtree root
            if(root.left==null)return root.right;// if left tree null replace with right subtree root
            TreeNode current=root.right;// reach the left most successor of rigth tree
            while(current.left!=null){
                current=current.left;
            }
            root.val=current.val;// replace value of root with left most successor of right tree
            root.right=deleteNode(root.right,root.val);// delete the left most successor of right tree
        }
        return root;

    }
}