dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

/*
dp[0] = 0 
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
      = Min{ dp[3]+1, dp[0]+1 } 
      = 1				
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
      = Min{ dp[4]+1, dp[1]+1 } 
      = 2
						.
						.
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
       = 2
       
       
dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

*/

import java.util.Hashtable;
public class Solution {
    
    
    Hashtable<Integer,Integer> H = new Hashtable<>();
    public int numSquares(int n) {
        if (H.containsKey(n))
            return H.get(n);
        else if (n == 1)
            return 1;
        else if (Math.floor(Math.sqrt(n)) == Math.sqrt(n))
            return 1;
        else
        {
            int x = (int)Math.floor(Math.sqrt(n));
            int min = Integer.MAX_VALUE;
            for (int i=x;i>0;i--)
            {
                int cnd = numSquares(n - (int)Math.pow(i,2));
                min = cnd<min?cnd:min;
            }
            H.put(n,1+min);
            return 1+min;
        }
    
    }
}
