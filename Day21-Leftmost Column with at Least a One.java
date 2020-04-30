/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        //binarysearch(r*logn)
        
        List<Integer> dimen = binaryMatrix.dimensions();
        int res= Integer.MAX_VALUE;
        int rows = dimen.get(0);
        int cols = dimen.get(1);
        if(rows == 0 || cols == 0){
            return -1;
        }
        for(int i= 0; i< rows ; i++){
            int l = 0;
             int r = cols -1;
            while(l<r){
              int mid = (l + r)/2;
                int x = binaryMatrix.get(i ,mid);
                if(x == 1){
                    res = Math.min(res, mid);
                    r = mid;
                }
                else{
                    l = mid+1;
                }
            }
        }
            
            if(res == Integer.MAX_VALUE){
                return -1;
            }
    return res;
            
        
  /* optimsed O(r + c)
        List<Integer> dimen = binaryMatrix.dimensions();
        int res=-1;
        int rows = dimen.get(0);
        int cols = dimen.get(1);
        if(rows == 0 || cols == 0){
            return -1;
        }
        int r = 0;
        int c = cols-1;
        while(r < rows && c >= 0){
          if(binaryMatrix.get(r,c) == 1){
              res = c;
              c--;
          }  
           else{
               r++;
           } 
        }
          
        return res;*/
    }
}