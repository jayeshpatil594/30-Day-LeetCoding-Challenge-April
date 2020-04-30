class Solution {
    /*
    //bactracking
    public boolean canJump(int[] nums) {
        return canJumpFromPos(0,nums);
    }
    public boolean canJumpFromPos(int pos, int[] nums){
        if(pos == nums.length-1){
            return true;
        }
        
        int furthestJump = Math.min(pos + nums[pos], nums.length-1);
        
        for(int nextPos = pos+1; nextPos<= furthestJump; nextPos++){
            if(canJumpFromPos(nextPos,nums)){
                return true;
            }
        }
        return false;
    }*/
    
    //greedy
    public boolean canJump(int[] nums){
        int lastpos = nums.length - 1;
        
        for(int i = lastpos ; i>=0 ; i--){
            if(i + nums[i] >= lastpos){
                lastpos = i;
            }
        }
        
        return lastpos == 0;
    }
}