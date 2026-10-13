class MyQueue {
    final private Stack<Integer> st;
    final private Stack<Integer> rez;

    public MyQueue() {
        st = new Stack<>();
        rez = new Stack<>();
    }
    
    public void push(int x) {
        st.add(x);
        
    }
    
    public int pop() {
        if(rez.isEmpty()){
            while(!st.isEmpty()){
                rez.push(st.pop());
            }
        }
        return rez.pop();

    }
    
    public int peek() {
        if(rez.isEmpty()){
            while(!st.isEmpty()){
                rez.push(st.pop());
            }
        }
        return rez.peek();

    }
    
    public boolean empty() {
        return st.isEmpty() && rez.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */