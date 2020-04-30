class Solution {
    public void moveZeroes(int[] nums) {
        int lastnonzero=0;
        //bring all non zero to the front
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[lastnonzero++]=nums[i];
            }
            }
        //fill the rest with zero
        for(int i=lastnonzero;i<nums.length;i++){
            nums[i]=0;
        } 
    }
}