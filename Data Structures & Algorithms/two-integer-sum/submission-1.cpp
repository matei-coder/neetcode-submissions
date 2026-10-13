class Solution {

public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int , int> conj;
        vector<int> ans;
        for(int i=0;i<nums.size() ;i++){
            if(conj.contains(target - nums[i])){
                ans.push_back(conj[target-nums[i]]);
                ans.push_back(i);
                return ans;
            }

            conj[nums[i]] = i;
        }

        return ans;
        
    }
};
