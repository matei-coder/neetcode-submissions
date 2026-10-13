class Solution {
public:
    bool validPalindrome(string s) {
        for(int i=0;i<(int)s.size();i++){
            if(isPalindrome(withouti(s , i))) return true;
        }
        if(isPalindrome(s)) return true;
        return false;
    }


    bool isPalindrome(string s) {
        string s2 =s;
        int n = s2.size();
        for(int i=0;i<n/2;i++){
            if(s2[i]!=s2[n-1-i]) return false;
        }
        return true;
    }

    string withouti(string s , int i){
        string s2;
        for(int j=0;j<(int)s.size();j++){
            if(j!=i) s2+=s[j];
        }
        return s2;
    }
};