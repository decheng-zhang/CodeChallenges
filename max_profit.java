/* Naive quadratic approach
public class Solution {
    public int maxProfit(int[] prices) {
        int max_profit=0;
        int profit = 0;
        for (int i=prices.length-1;i>=0;i--)
        {
            for (int j = i-1;j>=0;j-- )
            {
                profit = Math.max(profit,prices[i]-prices[j]);
            }
            if (profit>max_profit)
                max_profit = profit;
        }
        return max_profit;
    }
}
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int max_profit=0, profit=0;
        int bought = prices[0];
        for (int i=1;i<prices.length;i++)
        {
            profit = prices[i]-bought;
            max_profit=profit>max_profit?profit:max_profit;
            if (prices[i]<bought)
                bought=prices[i];
        }
       return max_profit;
    }
}
