class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
         vector<int> left(n), right(n);
        for(int i=0;i<n;++i){
            left[i] = (i==0) ? nums[0] : nums[i]*left[i-1]; 
        }
        for(int i=n-1;i>=0;--i){
            right[i] = (i==n-1) ? nums[n-1] : nums[i]* right[i+1];
        }
        vector<int> ans;
        for(int i=0;i<n;++i){
            //cout<<right[i] <<" "<<left[i]<<endl;
            int l = (i>0)? left[i-1] : 1;
            int r = (i<n-1) ? right[i+1] : 1;
            ans.push_back(l * r);
        }

        return ans;


    }
};
