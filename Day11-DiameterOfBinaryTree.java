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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res=1;
        depth(root);
        return res-1;
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=depth(root.left);
        int r=depth(root.right);
        res=Math.max(res,l+r+1);
        return Math.max(l,r)+1;
    }
}