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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null){
            return ans;
        }
        st.push(root);
        while(!st.isEmpty()){
            TreeNode s = st.pop();
            ans.add(0,s.val);
            if(s.left!=null){
                st.push(s.left);
            }
            if(s.right!=null){
                st.push(s.right);
            }
        }
        return ans;
    }
}
    //     List<Integer> ans = new ArrayList<>();
    //     postorder(root,ans);
    //     return ans;
    // }
    // private void postorder(TreeNode root,List<Integer> ans){
    //     if(root==null){
    //         return;
    //     }
    //     postorder(root.left,ans);
    //     postorder(root.right,ans);
    //     ans.add(root.val);