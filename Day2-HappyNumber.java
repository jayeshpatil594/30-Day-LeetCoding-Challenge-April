class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        set.add(n);
        while(true){
            if(n==1){
                return true;
            }
            n=sum(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
    }
    public int sum(int n){
        int sq=0;
        while(n!=0){
            int rem=n%10;
            sq+=rem*rem;
            n/=10;
        }
        return sq;
    }
}