class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int x : asteroids){
           
                while(!st.isEmpty() && st.peek()>=0 && st.peek()< (-1) * x && x < 0){
                    st.pop();
                }if(!st.isEmpty() && st.peek()>=0 && st.peek() == (-1) * x && x < 0){
                    st.pop();
                    continue;
                }
                if(!st.isEmpty() && st.peek()>=0 && st.peek() > (-1) * x && x < 0){
                    continue;
                }

                st.add(x);
            }
        

        int[] ans = new int[st.size()];
        while(!st.isEmpty()){
            ans[st.size()-1] = st.pop(); 
        } 

        return ans;
    }
}