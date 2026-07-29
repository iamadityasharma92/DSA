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
    int preIdx;// stores index of preorder for root
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx=0;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,preIdx,preorder.length-1);
    }

    TreeNode build(int[] preorder,int l,int r){
        if(l>r)return null;
        TreeNode root=new TreeNode(preorder[preIdx++]);//make node for root in current call
        int mid = map.get(root.val);// kyuki preIdx agge bhadda diya 
        root.left=build(preorder,l,mid-1);
        root.right=build(preorder,mid+1,r);
        return root;
    }
}
