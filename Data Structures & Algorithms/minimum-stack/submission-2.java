class MinStack {
    private final Stack<Integer> st;
    private final Map<Integer , Integer> valid;
    private final PriorityQueue<Integer> pq;

    public MinStack() {
        st = new Stack<>();
        valid = new HashMap<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        st.add(val);
        valid.put(val , valid.getOrDefault(val , 0)+1);
        pq.add(val);
    }
    
    public void pop() {
        int popped = st.pop();
        valid.put(popped , valid.get(popped) - 1);
        if(valid.get(popped) == 0) valid.remove(popped);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        while(!valid.containsKey(pq.peek())){
            pq.poll();
        }
        return pq.peek();
    }
}
