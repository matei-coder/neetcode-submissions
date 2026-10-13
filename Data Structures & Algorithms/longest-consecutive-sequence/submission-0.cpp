class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int> s1;
        for(int& x: nums) s1.insert(x);
        int maxCons = 0;
        for(int x : nums){
            if (s1.find(x - 1) == s1.end()) {
                int c = 1; 
                int cur = x;
                while (s1.find(cur + 1) != s1.end()) {
                    cur++;
                    c++;
                }
                maxCons = max(maxCons, c);
            }
        }


        return maxCons;
    }
};
