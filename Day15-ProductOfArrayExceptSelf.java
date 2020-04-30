class Solution {
    public int[] productExceptSelf(int[] nums) {
        
       int[] leftprod = new int[nums.length];
        leftprod[0]=1;
        for(int i=1;i<nums.length;i++){
            leftprod[i] = leftprod[i-1] * nums[i-1];
        }
        int rightprod=1;
        for(int i=nums.length-1;i>=0;i--){
            leftprod[i]=leftprod[i]*rightprod;
            rightprod*=nums[i];
        }
        return leftprod;
    }
}