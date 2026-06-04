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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        path(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
    private void path(TreeNode root, int targetSum,List<Integer> curr,List<List<Integer>> ans){
        if(root==null){
            return ;
        }
        curr.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                ans.add(new ArrayList<>(curr));
            }
            curr.remove(curr.size()-1);
            return;
        }
        path(root.left,targetSum-root.val,curr,ans);
        path(root.right,targetSum-root.val,curr,ans);
        curr.remove(curr.size()-1);
    }
}