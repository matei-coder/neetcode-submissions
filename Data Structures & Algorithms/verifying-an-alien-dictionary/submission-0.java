class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] freq = new int[26];
        for(int i=0;i<order.length();i++){
            
            freq[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            String decomp = words[i-1];
            String curr = words[i];
            if(!compare(decomp , curr , freq)){
                return false;
            }


        }

        return true;
    }

    private boolean compare(String a , String b, int[] freq){
        for(int i=0;i<Math.min(a.length() , b.length());i++){
            if(freq[a.charAt(i) -'a'] >freq[b.charAt(i) -'a']) return false;
            else if(freq[a.charAt(i) -'a'] < freq[b.charAt(i) -'a']) return true;
        }
        return b.length() >= a.length();
    }
}