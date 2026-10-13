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
            if(isInteger(operation)){
                st.add(Integer.parseInt(operation));
            }else{
                if(operation.equals("+")){
                    int a = st.pop();
                    int b = st.peek();
                    //System.out.println(a+b);
                    st.add(a);
                    st.add(a+b);
                }
                else if(operation.equals("C")){
                    st.pop();
                }
                else if(operation.equals("D")){
                    int a = st.pop();
                    //System.out.println(a);
                    st.add(a);
                    st.add(2*a);
                }
            }

        }

        while(!st.isEmpty()) {
            //System.out.println(st.peek());
            sum+=st.pop();}
        return sum;
    }
}