package paps;
/* Given an array of characters/Alphabets print all possible strings of given length k*/
public class paps {
	
	char[]A;
	int len;
	public paps(char[]s,int l)
	{
		A=s;
		len =l;
		GenStr("",len);
	}
	
	public void GenStr(String s,int rem)
	{
		if (rem==0)
			System.out.println(s);
		else
		{
			for (int i=0;i<A.length;i++)
			{
				//Add to prefix
				if (s.indexOf(A[i])<0) //does not contains this character
				{
					GenStr(s+A[i],rem-1);
				}
			}
		}
	}
	
	public static void main(String[]args)
	{
		char[]input = {'a','b','c','d','e','f'};
		paps P = new paps(input,3);
	}

}
