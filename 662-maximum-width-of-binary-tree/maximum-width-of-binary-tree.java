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
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.add(new Pair(root,0));
        int max=0;
        while(!queue.isEmpty()){
            int size = queue.size();

            long first = queue.peek().index;
            long last = first;
            for(int i=0;i<size;i++){
                Pair temp = queue.remove();
                long idx = temp.index;
                if(i==0){
                    first=idx;
                }
                if(i==size-1){
                    last=idx;
                }
                if(temp.node.left!=null){
                    queue.add(new Pair(temp.node.left,2*idx + 1));
                }
                if(temp.node.right!=null){
                    queue.add(new Pair(temp.node.right,2*idx + 2));
                }
            }
            max = Math.max(max,(int)(last-first+1));
        }
        return max;
    }
}