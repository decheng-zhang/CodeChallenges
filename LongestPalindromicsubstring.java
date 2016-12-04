package longestPalindromicSubstring;

public class Solution {
	
	public String longestPalindrome(String s)
	{
		int lenString = s.length();
		if (lenString == 1)
			return s;
		Boolean cache[][] = new Boolean[lenString][lenString];
		int len = 1;
		int startIndex = 0;
		//all strings of length 1 are palindrome
		for (int i=0;i<lenString;i++)
		{
			for (int j=0 ;j <lenString;j++)
			{
				cache[i][j] = true;
			}
		}
		//check for all Strings of length 2
		for (int i=0;i<lenString-1;i++)
		{
			if (s.charAt(i)==s.charAt(i+1))
				{
					cache[i][i+1]=true;
					startIndex = i;
					len = 2;
				}
			else
				cache[i][i+1]= false;
		}
		//check for all other lengths
		for (int k = 3;k<=lenString;k++)
		{
			for (int i = 0;i<=lenString-k;i++)
			{
				if (s.charAt(i)==s.charAt(i+k-1) && cache[i+1][i+k-2])
					{
						cache[i][i+k-1]=true;
						startIndex =i;
						len = k;
					}
				else
					cache[i][i+k-1]= false;
			}
		}
		
		return s.substring(startIndex, startIndex+len);
	}
	
	public static void main(String[] args)
	{
		String input = "abc";
		Solution S = new Solution();
		System.out.println(S.longestPalindrome(input));
	}

}
