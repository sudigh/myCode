class MyStack {
    Queue<Integer> que = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        que.offer(x);
        int queLen = que.size();
        while (queLen > 1) {
            que.offer(que.poll());
            queLen--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        que.poll();
    }

    // Get the top element.
    public int top() {
        return que.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return(que.isEmpty());
        
    }
}
