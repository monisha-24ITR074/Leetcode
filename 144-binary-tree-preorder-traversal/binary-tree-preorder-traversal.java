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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null){
            return ans;
        }
        st.push(root);
        while(!st.isEmpty()){
            TreeNode s = st.pop();
            ans.add(s.val);
            if(s.right!=null){
                st.push(s.right);
            }
            if(s.left!=null){
                st.push(s.left);
            }
        }
        return ans;
    }
}
    //     List<Integer> ans = new ArrayList<>();
    //     preorder(root,ans);
    //     return ans;
    // }
    // private void preorder(TreeNode root,List<Integer> ans){
    //     if(root==null){
    //         return;
    //     }
    //     ans.add(root.val);
    //     preorder(root.left,ans);
    //     preorder(root.right,ans);