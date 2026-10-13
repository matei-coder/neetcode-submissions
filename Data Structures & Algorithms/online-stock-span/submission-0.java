class StockSpanner {
    private final Stack<Integer> st;
    private final List<Integer> list;
    int i = 0;

    public StockSpanner() {
        st = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        while(!st.isEmpty() && price >= list.get(st.peek())){
            st.pop();
        }
        int ans = st.isEmpty() ? i + 1 : i - st.peek();
        st.push(i++);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */