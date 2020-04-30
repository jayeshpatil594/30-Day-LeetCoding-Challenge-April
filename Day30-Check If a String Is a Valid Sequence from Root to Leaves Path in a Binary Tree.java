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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null){
            return arr.length == 0;
        }
        return helper(root,arr, 0);
    }
    public boolean helper(TreeNode root, int[] arr, int pos){
        if(root == null || pos >= arr.length){
            return false;
        }
        
            if((root.left == null && root.right == null) && root.val == arr[pos] && root.val == arr[arr.length-1]){
                return true;
            }
        
        return pos< arr.length && (root.val == arr[pos] && (helper(root.left,arr, pos+1) || helper(root.right, arr, pos+1)));
    }
}