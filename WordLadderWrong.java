//package wordLadder;
import java.util.Arrays;
import java.util.List;
import java.util.Hashtable;
public class Solution {
    String end;
    List<String> dict;
    Hashtable<String,Boolean> inStack;
    Hashtable<String,Integer> cache;
    
    public int func(String begin)
    {
    	if (cache.containsKey(begin))
    		return cache.get(begin);
    	int dist=Integer.MAX_VALUE;
    	inStack.put(begin, true);
        if (begin.equals(end))
        {
        	inStack.put(begin, false);
        	return 0;
        }
        for (String word:dict)
        {
            int len = begin.length();
            int diff=0;
            for (int i=0;i<len;i++)
            {
                if (begin.charAt(i)!=word.charAt(i))
                    diff++;
            }
            if (diff!=1)
                continue;
            if (inStack.containsKey(word) && inStack.get(word))
            	continue;
        	int distViaPath = func(word);
        	dist = distViaPath<dist?distViaPath:dist;
        }
        inStack.put(begin, false);
        if (dist == Integer.MAX_VALUE)
        	{
        		cache.put(begin, dist);
        		//System.out.println(begin+" "+ dist);
        		return dist;
        	}
        cache.put(begin, 1+dist);
        //System.out.println(begin+" "+ (1+dist));

        return 1+dist;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        end = endWord;
        dict = wordList;
        inStack = new Hashtable<>();
        cache = new Hashtable<>();
        int sol = func(beginWord);
        return (sol==Integer.MAX_VALUE?0:1+sol);
       
        
    }
    
    public static void main(String[] args)
    {
    	Solution s = new Solution();
    	String begin="hit";
    	String end = "cog";
    	String[] list = new String[]{"hot","dot","dog","lot","log","cog"};
    	List<String> dict = Arrays.asList(list);
    	System.out.println(s.ladderLength(begin, end, dict));
    }
}
