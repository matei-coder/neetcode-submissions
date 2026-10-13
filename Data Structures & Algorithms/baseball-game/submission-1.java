class Solution {

    public static boolean isInteger(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }

    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        for(String operation : operations){          
            switch(operation){
                case "+"->{
                    int a = st.pop();
                    int b = st.peek();
                    st.add(a);
                    st.add(a+b);
                }
                case "C"->
                    st.pop();
                case "D"->
                    st.add(2*st.peek());
                default -> st.add(Integer.parseInt(operation));


            }
            

        }

        while(!st.isEmpty()) {
            System.out.println(st.peek());
            sum+=st.pop();}
        return sum;
    }
}