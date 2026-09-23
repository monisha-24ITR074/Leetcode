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
    int idx = 0;
    TreeNode dfs(int[] preorder,int[] inorder,HashMap<Integer,Integer> hm,int start,int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int i = hm.get(preorder[idx]);
        idx++;
        root.left = dfs(preorder,inorder,hm,start,i-1);
        root.right = dfs(preorder,inorder,hm,i+1,end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return dfs(preorder,inorder,hm,0,n-1);
    }
}