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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        if(root!=null)
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
            // iterate till queue size by this we'll traverse a level without polling extra nodes
            for(int i=q.size();i>0;i--){
                TreeNode n=q.poll();
                if(n!=null){
                    list.add(n.val);
                    if(n.left!=null)q.add(n.left);// array deque throws error while pushing null value into it 
                    if(n.right!=null)q.add(n.right);
                }
            }
            if(list.size()>0){
                res.add(list);
            }
        }
        return res;
    }
}
