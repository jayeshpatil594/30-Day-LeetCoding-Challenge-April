class Solution {
    public boolean checkValidString(String s) {
        int leftbalance=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                leftbalance++;
            }
            else{
                leftbalance--;
            }
            if(leftbalance<0){
                return false;
            }
        }
        int rightbalance=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')' || s.charAt(i)=='*'){
                rightbalance++;
            }
            else{
                rightbalance--;
            }
            if(rightbalance<0){
                return false;
            }
        }
        return true;
    }
}