class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] commands = path.split("/" , -1);
        for(String s : commands){
            switch (s){
                case "." , "" ->{
                    continue;
                }
                case ".." ->{
                    if(!st.isEmpty()){
                        st.pop();
                    }                   
                }
                default ->{
                    st.add(s);
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()) sb.append("/");

        for(String s : st){
            sb.append("/").append(s);
        }

        return sb.toString();


    }
}