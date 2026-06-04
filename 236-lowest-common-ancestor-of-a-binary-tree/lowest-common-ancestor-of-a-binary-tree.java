/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp=new ArrayList<>();
        List<TreeNode> pathq=new ArrayList<>();
        List<TreeNode> ans1=new ArrayList<>();
        List<TreeNode> ans2=new ArrayList<>();
        find(root,p,ans1,pathp);
        find(root,q,ans2,pathq);
        TreeNode ans=null;

        for (int i=0;i<Math.min(pathp.size(),pathq.size());i++){
            if(pathp.get(i)==pathq.get(i)){
                ans=pathp.get(i);
            }
            else{
                break;
            }
        }
        return ans;
    }
    public void find(TreeNode root,TreeNode target,List<TreeNode> curr,List<TreeNode> result){
        if(root==null){
            return;
        }
        curr.add(root);
        if(root==target){
            result.addAll(curr);
            return;
        }
        find(root.left,target,curr,result);
        find(root.right,target,curr,result);
        curr.remove(curr.size()-1);
    }
}


















// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> pathp=new ArrayList<>();
//         List<TreeNode> pathq=new ArrayList<>();
//         List<TreeNode> ans1=new ArrayList<>();
//         List<TreeNode> ans2=new ArrayList<>();
//         find(root,p,ans1,pathp);
//         find(root,q,ans2,pathq);
//         TreeNode ans=null;

//         for (int i=0;i<Math.min(pathp.size(),pathq.size());i++){
//             if(pathp.get(i)==pathq.get(i)){
//                 ans=pathp.get(i);
//             }
//             else{
//                 break;
//             }
//         }
//         return ans;
//     }
//     public void find(TreeNode root,TreeNode target,List<TreeNode> curr,List<TreeNode> result){
//         if(root==null){
//             return;
//         }
//         curr.add(root);
//         if(root==target){
//             result.addAll(curr);
//             return;
//         }
//         find(root.left,target,curr,result);
//         find(root.right,target,curr,result);
//         curr.remove(curr.size()-1);

//     }
// }