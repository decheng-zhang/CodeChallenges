import java.util.Hashtable;
public class Solution {
    
    Hashtable<String,Boolean> cache;
    
    public boolean victory(int target_total, int[]state)
    {
        String key = Arrays.toString(state);
        
        if (cache.containsKey(key))
            {
                //System.out.println("hit");
                return cache.get(key);
            }
        for (int i =0;i<state.length;i++)
        {
            if (state[i]==1)
                continue;
            if (target_total<=i+1)
            {
                    cache.put(key,true);
                    return true;
            }
            state[i]=1;
            if  (!victory(target_total-(i+1),state))
            {
                    cache.put(key,true);
                    state[i]=0;
                    return true;
            }
            state[i]=0;
        }
        cache.put(key,false);
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    
        if ((maxChoosableInteger*(maxChoosableInteger+1))/2 < desiredTotal)
            return false;
            
        int[] tokens = new int[maxChoosableInteger];
        cache = new Hashtable<>();
        return victory(desiredTotal,tokens);
    
    }
}


