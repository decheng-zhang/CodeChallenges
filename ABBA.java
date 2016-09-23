public class ABBA {
	
	String initial,target;
	
	public String canObtain(String I,String T)
	{
		this.initial =I;
		this.target= T;
		if (ispossible(I,T))
			return "Possible";
		else
			return "Impossible";
		
	}
	
	private String reverse(String S)
	{
		char[] input = S.toCharArray();
		char[] output = new char[input.length];
		int i=0;
		for (int j=input.length-1;j>=0;j--)
			output[i++]=input[j];
		return new String(output);
	}
	
	private Boolean ispossible(String I,String T)
	{
		if (I.length() > T.length())
			return false;
		else
		{
			if (I.equals(T))
				return true;
			if ((I+"A").equals(T))
				return true;
			String rev = reverse(I);
			if ((rev+"B").equals(T))
				return true;
			return (ispossible(I+"A",T) || ispossible(rev+"B",T));		
		}
	}
	
	public static void main(String[] args)
	{
		ABBA A = new ABBA();
		System.out.println(A.canObtain("B","ABBA"));
	}
		
}

