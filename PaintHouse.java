public class Solution {
    public int minCost(int[][] costs) {
        
        if (costs.length==0 || costs[0].length==0)
            return 0;
        
        int [][]expenses = new int[costs.length][costs[0].length];
        for (int i=0;i<costs[0].length;i++)
            expenses[0][i]=costs[0][i];
            
        for (int i=1;i<expenses.length;i++)
        {
            expenses[i][0]=costs[i][0]+Math.min(expenses[i-1][1],expenses[i-1][2]);
            expenses[i][1]=costs[i][1]+Math.min(expenses[i-1][0],expenses[i-1][2]);
            expenses[i][2]=costs[i][2]+Math.min(expenses[i-1][0],expenses[i-1][1]);
        }
        
        int min_val = Integer.MAX_VALUE;
        for (int i=0;i<expenses[0].length;i++)
        {
           if (expenses[expenses.length-1][i]<min_val)
            min_val = expenses[expenses.length-1][i];
        }
        
        return min_val;
    }
}
