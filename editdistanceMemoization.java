

import java.util.Arrays;
import java.util.Hashtable;
public class Solution {
	
	Hashtable<String,Integer> cache= new Hashtable<>();
	public int minDistance(String word1, String word2) {
	    if (word1.equals(word2))
	        return 0;
	    else
	    {
	       if (cache.containsKey(word1+word2))
	    	   {
	    	   		System.out.println("hit");
	    	   		return cache.get(word1+word2);
	    	   }
	       else
	       {
	    	   int[] temp=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
	    	   if (word1.length()==0)
	    		   return word2.length();
	    	   if (word2.length()==0)
	    		   return word1.length();
	    	   if (word1.charAt(0)==word2.charAt(0))
	    		   temp[0]=minDistance(word1.substring(1),word2.substring(1));
	    	   temp[1] = 1 + minDistance(word1,word2.substring(1));
	    	   temp[2] = 1 + minDistance(word1.substring(1),word2);
	    	   temp[3] = 1 + minDistance(word1.substring(1),word2.substring(1));
	    	   Arrays.sort(temp);
	    	   cache.put(word1+word2, temp[0]);
	    	   return temp[0];
	       }
	       	
	    }   
	}
	
	public static void main(String[] args)
	{
		Solution s = new Solution();
		String w1 = "cat";
		String w2 = "mat";
		System.out.println(s.minDistance(w1, w2));
	}

}

