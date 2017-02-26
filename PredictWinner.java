import java.lang.*;
import java.util.HashMap;
public class Solution {
    
    HashMap<pair,Integer> H = new HashMap<>();
    Boolean chooseLeft = false;
    private class pair 
    {
        int a,b;
        public pair(int a, int b)
        {
            this.a = a; this.b = b;
        }
        
        @Override
        public int hashCode()
        {
            return (int) (a*Math.pow(13,0)+b*Math.pow(13,1));
        }
        
        @Override
		public boolean equals(Object o)
		{
			pair that = (pair) o;
			
			if (this.a == that.a && this.b == that.b)
				return true;
			else
				return false;
		}
    }
    
    private int maxscore(int[] nums, int start, int end)
    {
        pair p = new pair(start, end);
        int result;
        if (H.containsKey(p))
            return H.get(p);
        else {
        int size = end - start + 1;
        if (size <= 0 )
            result = 0;
        else
            {
                //else two choices- choose left, choose right
                int fromLeft = nums[start] + Math.min(maxscore(nums,start+2,end), maxscore(nums,start+1,end-1));
                int fromRight = nums[end] + Math.min(maxscore(nums,start+1,end-1), maxscore(nums,start,end-2));
                
                if (fromLeft > fromRight)
                    chooseLeft = true;
                else
                    chooseLeft = false;
                result = Math.max(fromLeft,fromRight);
            }
            H.put(p,result);
            return result;
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        
        int P1_score = maxscore(nums,0,nums.length-1);
        int P2_score;
        if (chooseLeft)
            P2_score = maxscore(nums,1,nums.length-1);
        else
            P2_score = maxscore(nums,0,nums.length-2);
            
        if (P1_score >= P2_score)
            return true;
        else
            return false;
    }
}
