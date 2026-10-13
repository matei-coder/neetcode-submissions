class Solution {
public:
    bool validPalindrome(string s) {

        for(int i=0;i<(int)s.size();i++){
            string r = s;
            r.erase(i, 1);
            string t = r;
            reverse(t.begin() , t.end());
            if(t==r) return true;

        }
        return s == string(s.rbegin() , s.rend());
    }


};