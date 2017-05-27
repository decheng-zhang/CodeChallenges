
import java.util.Arrays;

public class Solution {
	int[][]cache;
	public int minDistance(String word1, String word2) {
		if (word1.length()==0)
			return word2.length();
		if (word2.length()==0)
			return word1.length();
		cache = new int[word2.length()+1][word1.length()+1];
		for (int i=0;i<cache[0].length;i++)
			cache[0][i]=i;
		for (int i=0;i<cache.length;i++)
			cache[i][0]=i;
		int[]candidates = new int[4];
		for (int i=1;i<cache.length;i++)
		{
			for (int j=1;j<cache[0].length;j++)
			{
				Arrays.fill(candidates, Integer.MAX_VALUE); 
				if (word1.charAt(j-1)==word2.charAt(i-1))
					candidates[0]=cache[i-1][j-1];
				candidates[1]=1+cache[i-1][j];
				candidates[2]=1+cache[i][j-1];
				candidates[3]=1+cache[i-1][j-1];
				Arrays.sort(candidates);
				cache[i][j]=candidates[0];			
			}
		}
		
//		for (int i=0;i<cache.length;i++)
//		{
//			System.out.println("");
//			for (int j=0;j<cache[0].length;j++)
//				System.out.print(cache[i][j]+"\t");
//		}
//		System.out.println("");
		return cache[cache.length-1][cache[0].length-1];
	}
	
	public static void main(String[] args)
	{
		Solution s = new Solution();
		String w1 = "apple";
		String w2 = "pi";
		System.out.println(s.minDistance(w1, w2));
	}
}
