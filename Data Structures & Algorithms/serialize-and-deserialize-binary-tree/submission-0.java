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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        dfs(root,s);
        if(s.length()>0)
        s.deleteCharAt(0);
        return s.toString();
    }

    void dfs(TreeNode root,StringBuilder s){
        if(root==null){
            s.append(",");
            s.append("N");
            return;
        }
        s.append(",");
        s.append(root.val);
        dfs(root.left,s);
        dfs(root.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>();
        String[] arr=data.split(",");
        Collections.addAll(q,arr);
        return build(q);
    }

    TreeNode build(Queue<String> q){
        if(q.isEmpty())return null;

        String s=q.poll();
        if("N".equals(s)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(s));

        root.left=build(q);
        root.right=build(q);
        return root;
    }
}
