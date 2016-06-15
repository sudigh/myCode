public class MinStack {

    /** initialize your data structure here. */
    public int min = Integer.MAX_VALUE;
    Stack<Integer> stk = new Stack<>();
    public MinStack() {
    }
    
    public void push(int x) {
        if (x <= min) { 
            stk.push(min); // Push min twice
            min = x;
        }
        stk.push(x);
    }
    
    public void pop() {
        if (stk.peek() == min) {
            stk.pop();    // Pop current min and then set min to the new current min and pop it (since min is pushed twice)
            min = stk.pop();
        } else {
            stk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
       return min; 
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
