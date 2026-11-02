class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] nrOfCoins = new int[amount+1];
        //nrOfCoins[i] = number of coins we need to use to make amount i
        Arrays.fill(nrOfCoins, amount + 1);
        nrOfCoins[0] = 0;
   
        for(int j=0;j<=amount;j++){
            for(int i=0;i<coins.length;i++){
                if(j>=coins[i])
                    nrOfCoins[j] = Math.min(nrOfCoins[j] , 1+nrOfCoins[j-coins[i]]);
            }
        }

        return (nrOfCoins[amount] == amount+1) ? -1 : nrOfCoins[amount];
        

    }
}
