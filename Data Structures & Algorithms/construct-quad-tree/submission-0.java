/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    public Node construct(int[][] grid) {
        
       return bringChild(grid,grid.length,0,0);
    }

    public Node bringChild(int[][] grid,int n,int r,int c){
        if(n==1) 
        return new Node(grid[r][c]==1,true);

        n=n/2;
        Node tl=bringChild(grid,n,r,c);
        Node tr=bringChild(grid,n,r,c+n);
        Node bl=bringChild(grid,n,r+n,c);
        Node br=bringChild(grid,n,r+n,c+n);

        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val==tr.val && tl.val==bl.val && tl.val==br.val){
            return tl;
        }
        return new Node(true,false,tl,tr,bl,br);


    }
}