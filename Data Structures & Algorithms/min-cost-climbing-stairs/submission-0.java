class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];

        dp[0]= cost[0] ; dp[1] = cost[1];
        
        //dp[i] = Math.min(dp[i-1] , dp[i-2])
        for(int i=2 ; i<len ;i++){
            dp[i] = cost[i] + Math.min(dp[i-1] , dp[i-2]);
        }

        return Math.min(dp[len-1] , dp[len-2]);
    }
}
