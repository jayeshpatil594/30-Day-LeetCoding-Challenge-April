class Solution {
    public String stringShift(String s, int[][] shift) {
        int count=0;
        for(int i=0;i<shift.length;i++){
            count+=(shift[i][0]==0)?shift[i][1]:-shift[i][1];
        }
        if(count>s.length() || -count>s.length()){
            count=count%s.length();
        }
        if(count<0){
            count=s.length()+count;
        }
        return s.substring(count)+s.substring(0,count);
    }
}