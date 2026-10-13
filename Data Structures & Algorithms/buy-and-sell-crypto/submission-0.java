class Solution {
    public int maxProfit(int[] prices) {
        int ans =0;
        int minim = prices[0];
        int maxim = prices[0];
        for(int right=0; right<prices.length ; right++){
            minim = Math.min(minim , prices[right]);
            maxim = Math.max(0, prices[right]);
            ans = Math.max(ans , maxim-minim);
        }

        return ans;
    }
}
