class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            switch (c){
                case '[','(','{' ->{
                    st.add(c);
                }
                case '}'-> {
                    if(st.isEmpty() ||st.pop() != '{') return false;
                }
                case ']'-> {
                    if(st.isEmpty() || st.pop() != '[') return false;
                }
                case ')'-> {
                    if(st.isEmpty() ||st.pop() != '(') return false;
                }
            }
        }
        return st.size() == 0;
    }
}
