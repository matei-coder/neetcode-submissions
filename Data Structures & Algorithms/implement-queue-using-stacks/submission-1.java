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
        for(int i = st.size();i>0;i--){
            rez.add(st.pop());
        }
        int dorit = rez.pop();
        for(int i = rez.size();i>0;i--){
            st.add(rez.pop());
        }

        return dorit;

    }
    
    public int peek() {
        for(int i = st.size();i>0;i--){
            rez.add(st.pop());
        }
        int dorit = rez.peek();
        
        for(int i = rez.size();i>0;i--){
            st.add(rez.pop());
        }

        return dorit;

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