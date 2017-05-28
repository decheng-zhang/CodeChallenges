public class Solution {
    public int maxProfit(int k, int[] prices) {
        /**
         * cache[i, j] represents the max profit up until prices[j] using at most i transactions. 
         * cache[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
         *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
         * cache[0, j] = 0; 0 transactions makes 0 profit
         * cache[i, 0] = 0; if there is only one price data point you can't make any transaction.
         */
        int len = prices.length;
        int profit=0;
        if (k >= len/2)
        {
            for (int i = 1;i<len;i++)
            {
                profit += Math.max(prices[i]-prices[i-1],0);
            }
            return profit;
        }
        else
        {
            int [][]cache = new int[k+1][len];
            for (int i=0;i<len;i++)
                cache[0][i]=0;
            int OneLessTransactionMax = Integer.MIN_VALUE;
            for (int i=1;i<k+1;i++)
            {
                for (int j = 1;j<len;j++)
                {
                    OneLessTransactionMax = Math.max(OneLessTransactionMax,cache[i-1][j-1]-prices[j-1]);
                    cache[i][j]= Math.max(cache[i][j-1],prices[j]+OneLessTransactionMax);
                }
                OneLessTransactionMax = Integer.MIN_VALUE;
            }
            return cache[k][len-1];
        }
    }
}
