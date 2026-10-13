class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        for (int x : nums) {
            freq[x]++;
        }

        // min-heap de mărime k: {frecventa, valoare}
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;

        for (auto& [val, count] : freq) {
            pq.push({count, val});
            if (pq.size() > k) {
                pq.pop(); // eliminăm cea mai mică frecvență din top-k curent
            }
        }

        vector<int> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};