class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+" ->{
                    st.add(st.pop() + st.pop());
                }
                case "*" ->{
                    st.add(st.pop() * st.pop());
                }
                case "/" ->{
                    int a = st.pop();
                    int b = st.pop();
                    st.add(b/a);
                }
                case "-" ->{
                    st.add(-(st.pop() - st.pop()));
                }
                default ->{
                    st.add(Integer.parseInt(token));
                }
            }
        }

        return st.pop();
    }
}
