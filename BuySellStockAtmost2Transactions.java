public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        int[][]cache = new int[3][prices.length];
        //initial row
        for (int i=0;i<prices.length;i++)
            cache[0][i]=0;
        int MaxOneLessTransaction=Integer.MIN_VALUE;
        for (int i=1;i<3;i++)
        {
            cache[i][0]=0;
            for (int j=1;j<prices.length;j++)
            {
                MaxOneLessTransaction = Math.max(MaxOneLessTransaction,cache[i-1][j-1]-prices[j-1]);
                cache[i][j]=Math.max(cache[i][j-1],MaxOneLessTransaction+prices[j]);
            }
            MaxOneLessTransaction=Integer.MIN_VALUE;
        }
        
        return cache[2][prices.length-1];
        
    }
}
/* cache[i][j] max profit with atmost i transactions till day j.
    two choices - do no transaction (inherit from previous), OR do transaction
    - inherit the maxprofit by doing one fewer transactions earlier (from all previous days)
    */
