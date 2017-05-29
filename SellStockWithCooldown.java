//https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        //following the state machine concept, 3 states based on actions.
        int[]s_0 = new int[prices.length]; // max profit on day i when state is s_0
        int[]s_1 = new int[prices.length];
        int[]s_2 = new int[prices.length];
        
        // initializing 
        s_0[0]= 0; // get here from rest, did nothing.
        s_1[0]= -prices[0]; //bought the stock
        s_2[0]= Integer.MIN_VALUE; // not possible, could not sell here.
        
        for (int i=1;i<prices.length;i++)
        {
            s_0[i]=Math.max(s_0[i-1],s_2[i-1]);
            s_1[i]=Math.max(s_0[i-1]-prices[i],s_1[i-1]);
            s_2[i]=s_1[i-1]+prices[i];
        }
        
        return Math.max(s_0[prices.length-1],s_2[prices.length-1]);
        
    }
}
