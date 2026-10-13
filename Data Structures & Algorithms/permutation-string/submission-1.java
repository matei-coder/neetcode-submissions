class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k =  s1.length();
        if (k > s2.length()) return false;
        boolean ans = false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char c: s1.toCharArray()) freq1[c - 'a']++;

        for(int i=0;i<k;i++){
            freq2[s2.charAt(i) - 'a']++;
        }
        ans = ans || perm(freq1 , freq2);

        for(int i=k;i<s2.length();i++){
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - k) - 'a']--;

            ans = ans || perm(freq1 , freq2);
        }




        return ans;
    }



    public boolean perm(int[] freq1 , int[] freq2){
        boolean ans = true;
        for(int i=0;i<freq1.length;i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
