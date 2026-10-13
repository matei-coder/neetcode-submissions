class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int , int> prefix_sums;
        prefix_sums[0]++;
        int sum = 0;

        int ans=0;
        for(int i=0;i<(int)nums.size();++i){
            sum+= nums[i];
            
            if(prefix_sums.find( sum - k)!= prefix_sums.end()){
                ans+= prefix_sums[sum-k];
            }
            prefix_sums[sum]++;
        }

        return ans;

    }
};