import java.util.List;
import java.util.Queue;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Arrays;
public class Solution {
	Hashtable<String,Integer> visited = new Hashtable<>();
	Queue<String> Q = new LinkedList<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	
    	Q.offer(beginWord);
    	visited.put(beginWord,0);
    	while (!Q.isEmpty())
    	{
    		String polled = Q.poll();
    		int dist = visited.get(polled);
    		if (polled.equals(endWord))
    			return (1+dist);
    		for (String word:wordList)
    		{
    			int diff =0;
    			int len = word.length();
    			for (int i=0;i<len;i++)
    			{
    				if (polled.charAt(i)!=word.charAt(i))
    					diff++;
    			}
    			if (diff==1)
    			{
    				if (visited.containsKey(word))
    					continue;
    				visited.put(word,dist+1);
    				Q.offer(word);
    			}
    		}
    	}
    	
    	return 0;
        
    }
    
    public static void main(String[] args)
    {
    	String input = "hit";
    	String target = "cog";
    	String[] list = new String[]{"hot","dot","dog","lot","log","cog"};
    	Solution s = new Solution();
    	System.out.println(s.ladderLength(input, target, Arrays.asList(list)));
    }
}
