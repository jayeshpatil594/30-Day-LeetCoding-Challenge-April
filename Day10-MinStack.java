class MinStack {

    /** initialize your data structure here. */
    //normal stack
    private Stack<Integer> stack=new Stack<Integer>();
    //stack for storing the min for each level in above stack
    private Stack<Integer> minstack;
    public MinStack() {
        minstack=new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x<=getMin()){
            minstack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        int val=stack.pop();
        if(val==getMin()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minstack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else{
            return minstack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */