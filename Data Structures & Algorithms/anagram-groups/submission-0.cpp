class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string , vector<string>> harta;
        vector<vector<string>> ans;
        for(string s : strs){
            string temp = s;
            sort(s.begin() , s.end());
            harta[s].push_back(temp);

        }

        for( auto& x : harta){
            ans.push_back(x.second);
        }


        return ans;
    }
};
