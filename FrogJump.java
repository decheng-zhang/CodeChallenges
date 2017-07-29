import java.util.HashMap;
import java.util.HashSet;
public class Solution {
    
    HashMap<Integer,HashSet<Integer>> dest = new HashMap<>();
    public boolean canCross(int[] stones) {
        if (stones[1]!=1)
            return false;
        for (int i=0;i<stones.length;i++)
        {
            dest.put(stones[i], new HashSet<Integer>());
        }
        dest.get(stones[0]).add(stones[0]+1);
        for (int i=0;i<stones.length;i++)
        {
            int src = stones[i];
            HashSet<Integer> destinations = dest.get(src);
            for (int d:destinations)
            {
                if (d==stones[stones.length-1])
                    return true;
                int steps = d-src;
                if ((steps-1) != 0 && dest.containsKey(d+(steps-1)))
                    dest.get(d).add(d+steps-1);
                if (dest.containsKey(d+(steps)))
                    dest.get(d).add(d+steps);
                if (dest.containsKey(d+(steps+1)))
                    dest.get(d).add(d+steps+1);
                
                
            }
        }
        
        return false;
        
    }
}
