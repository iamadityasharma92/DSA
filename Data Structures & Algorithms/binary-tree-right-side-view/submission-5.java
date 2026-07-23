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
    public List<Integer> rightSideView(TreeNode root) {
        // perform BFS store the last element of queue in each level traversal
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue= new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){

            for(int i=queue.size();i>0;i--){
                TreeNode q=queue.poll();
                if(q.left!=null)
                queue.add(q.left);
                if(q.right!=null)
                queue.add(q.right);
                if(i==1)
                res.add(q.val);
            }
        }
        return res;
    }
}
