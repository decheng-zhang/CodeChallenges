class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int running_gain = 0;
        int gain  = 0;
        int start = 0;
        /* running_gain checks for existence of solution
        given solution exists we start with the assumption that initial index 0 is the starting point
        if the gain becomes less than or equal to 0, we know that our initially thought starting point could 
        not be correct, as a matter of fact any point between starting point and current position including both 
        cannot be starting points, since to start at i gas[i]-cost[i] should be >0 and at all subsequent points to 
        right for a solution to exist or to allow us to keep moving right gain[k] should be > 0 */
        for (int i=0;i<gas.length;i++)
        {   
            gain += gas[i]-cost[i];
            running_gain+=gas[i]-cost[i];
            if (gain<=0)
            {
                gain = 0;
                start=(i+1)%gas.length;
            }
        }
        for (int i=0;i<gas.length;i++)
        {
            
        }
        if (running_gain<0)
            return -1;
        else
            return start;
        
    }
}
