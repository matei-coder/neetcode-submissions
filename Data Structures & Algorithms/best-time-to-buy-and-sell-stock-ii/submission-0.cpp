class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int price = 1e9;
        int profit = 0;
        for(int i=0;i<(int) prices.size() ;i++){
            if(prices[i] <= price){
                price = prices[i];
            }else{
                profit += prices[i] - price;
                price = prices[i];
            }


        }


        return profit;
    }
};