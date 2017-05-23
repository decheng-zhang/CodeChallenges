/* Local minima local maxima flawed approach fails with tabletop curves--works for unique values */
/* failed for - [5,4,9,3,8,5,5,1,6,8,3,4], failed at 5,5 which it thinks is a local maxima */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
       int profit =0;
       int net_profit = 0;
       int bought=prices[0];
       for (int i=1;i<prices.length;i++)
       {
           //is minima
           if ((prices[i]<=prices[i-1] && i+1>=prices.length) || (prices[i]<=prices[i-1]&&prices[i]<prices[i+1]))
                {
                    bought=prices[i];
                    //System.out.println("bought "+bought);
                }
            else if ((prices[i]>=prices[i-1] && i+1>=prices.length) || (prices[i]>=prices[i-1]&&prices[i]>prices[i+1]))
                {
                    if (prices[i]-bought>0)
                        {
                            net_profit+=prices[i]-bought;
                            //System.out.println("sold at "+prices[i]+" made profit of "+net_profit);
                        }
                }
       }
       return net_profit;
        
    }
}

/////////////////////////////  Approach-2 (correct) //////////////////////////

/* find next Local minima-buy then find next local maxima after minima point and sell */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
       int profit =0;
       int net_profit = 0;
       int bought=prices[0];
       for (int i=1;i<prices.length;i++)
       {
           //is minima
           if ((prices[i]<=prices[i-1] && i+1>=prices.length) || (prices[i]<=prices[i-1]&&prices[i]<prices[i+1]))
                {
                    bought=prices[i];
                    //System.out.println("bought "+bought);
                }
            else if ((prices[i]>=prices[i-1] && i+1>=prices.length) || (prices[i]>=prices[i-1]&&prices[i]>prices[i+1]))
                {
                    if (prices[i]-bought>0)
                        {
                            net_profit+=prices[i]-bought;
                            //System.out.println("sold at "+prices[i]+" made profit of "+net_profit);
                        }
                }
       }
       return net_profit;
        
    }
}
