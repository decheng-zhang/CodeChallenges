import java.util.Hashtable;
public class Solution {
    
    Hashtable<String,Integer> H  = new Hashtable<>();
    public int f(String s) {
       
        if (H.containsKey(s))
            return H.get(s);
        else if (s.startsWith("0"))
            return Integer.MIN_VALUE; //invalid branch of computation.
        else if (s.length()==1 || s.length()==0)
            {
                H.put(s,1);
                return 1;
            }
        else
        {
           int option1 = 0; int option2 = 0; int result = 0;
           //decode first character
           option1 = f(s.substring(1));
            
            //decode first two characters
           if (Integer.parseInt(s.substring(0,2))<=26)
           {
               option2 = f(s.substring(2));
           }
           if (option1>0) //prune branch
                result+=option1;
            if (option2>0) //prune branch
                result+=option2;
            if (option1<0 && option2<0)
                {
                    H.put(s,Integer.MIN_VALUE);
                    return Integer.MIN_VALUE; //signifies invalid branch 
                }
            else
                {
                    H.put(s,result);
                    return result;
                }
        }
    }
    
    public int numDecodings(String s)
    {
        if (s.length()==0)
            return 0;
        int res = f(s);
        return res<0?0:res;
    }
}
