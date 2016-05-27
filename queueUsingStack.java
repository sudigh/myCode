class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        tmp.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (queue.isEmpty()) {
            while(!tmp.isEmpty()) {
                queue.push(tmp.pop());
            }
        }
        if (!queue.isEmpty()) {
            queue.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (queue.isEmpty()) {
            while(!tmp.isEmpty()) {
                queue.push(tmp.pop());
            }
        }
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (queue.isEmpty() && tmp.isEmpty()) {
            return true;
        }
        return false;
    }
}
