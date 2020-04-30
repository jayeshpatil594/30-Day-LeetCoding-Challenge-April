class Solution {
    public int maxSubArray(int[] nums) {
        int max_local=nums[0];
        int max_global=nums[0];
        for(int i=1;i<nums.length;i++){
            max_local=Math.max(max_local+nums[i],nums[i]);
            max_global=Math.max(max_local,max_global);
        }
        return max_global;
    }
}