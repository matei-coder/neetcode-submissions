class Solution {
public:
    bool isPalindrome(string s) {
        string s2;
        for(char c : s){
            if(alphanumeric(c)) s2+=tolower(c);
        }
        cout<<s2;
        int n = s2.size();
        for(int i=0;i<n/2;i++){
            if(s2[i]!=s2[n-1-i]) return false;
        }
        return true;
    }

    bool alphanumeric(char c){
        if(c<='Z'&& c>='A') return true;
        else if(c>='a'&&c<='z') return true;
        else if(c>='0'&&c<='9') return true;
        else return false;
    }
};
