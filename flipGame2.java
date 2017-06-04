import java.util.Hashtable;
public class Solution {
    
   public boolean canWin(String S)
    {
    	StringBuilder temp= new StringBuilder(S);
    	for (int i=0;i<S.length()-1;i++)
    	{
    		if (S.substring(i,i+2).equals("++"))
    		{
    			temp = temp.replace(i, i+2, "--");
    			if (!canWin(temp.toString()))
    				return true;
    			temp = temp.replace(i, i+2, "++");
    		}
    	}
    	return false;
        
    }
 
}
