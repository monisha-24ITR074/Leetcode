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
    int idx;
    TreeNode dfs(int[] inorder,int[] postorder,HashMap<Integer,Integer> hm ,int start,int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(postorder[idx]);
        int i = hm.get(postorder[idx]);
        idx--;
        root.right = dfs(inorder,postorder,hm,i+1,end);
        root.left = dfs(inorder,postorder,hm,start,i-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        idx = n-1;
        return dfs(inorder,postorder,hm,0,n-1);
    }
}