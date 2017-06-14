import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
public class Solution {
	
	HashMap<String,List<String>> cache;
	List<String> dict;
	public List<String> func(String input)
	{
		if (input.length()==0)
			return null;
		if (cache.containsKey(input))
			return cache.get(input);
		LinkedList<String> sol = new LinkedList<String>();
		for (String match:dict)
		{
			if (input.startsWith(match))
			{
				List<String> temp = func(input.substring(match.length()));
				if (temp==null)
				{
					sol.add(match);
					continue;
				}
				for (String s:temp)
				{
					sol.add(match+" "+s);
				}	
			}
		}
		
		cache.put(input, sol);
		return sol;
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
			cache = new HashMap<>();
	        dict = wordDict;
	        return func(s);
	    }
	
	public static void main(String[] args)
	{
		Solution s = new Solution();
		String input = "catsanddog";
		String[]dict = new String[]{"cat", "cats", "and", "sand", "dog"};
		List<String> ans = s.wordBreak(input, Arrays.asList(dict));
		for (String sol:ans)
			System.out.println(sol);
	}

}
