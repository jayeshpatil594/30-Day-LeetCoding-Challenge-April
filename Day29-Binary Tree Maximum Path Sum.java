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
    int max_sum;
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_sum;
    }
    public int pathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //max sum on the left and right subtrees of the current node
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        // price if we start a new path where current root is the highest node
        int newpath_sum = root.val + left + right;
        //update max_sum if its better to start a newpath
        max_sum = Math.max(max_sum, newpath_sum);
        // for recursion return the max_gain if we follow the same path
        return root.val + Math.max(left, right);
    }
}