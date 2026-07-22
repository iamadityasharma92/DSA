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
        if(root==null) return root;
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{//equal case
            if(root.right==null) return root.left;// for replacing the node found
            if(root.left==null) return root.right;
            //now find left most child of right subtree
            TreeNode temp=root.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            // assign deleting key with left most child of right tree
            root.val=temp.val;
            // delete left most child of right tree
            root.right=deleteNode(root.right,root.val);
        }
        return root;
    }
}