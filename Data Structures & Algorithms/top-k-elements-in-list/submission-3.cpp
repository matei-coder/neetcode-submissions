class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        const int OFFSET = 10000;
        vector<int> freq(20001, 0);
        for (int x : nums) {
            freq[x + OFFSET]++;
        }

        priority_queue<pair<int,int>> pq; 

        for (int i = 0; i < (int)freq.size(); i++) {
            if (freq[i] > 0) {
                pq.push({freq[i], i - OFFSET});
            }
        }

        vector<int> ans;
        while (!pq.empty() && k > 0) {
            ans.push_back(pq.top().second);
            pq.pop();
            k--;
        }

        return ans;
    }
};