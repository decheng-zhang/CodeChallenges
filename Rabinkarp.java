import java.math.BigInteger;
import java.util.Random;
public class RH {
	
	String pattern;
	long R = 256;
	long q;
	int n;//denotes search text length
	int m;//denotes pattern length
	long patHash = 0;
	long RM;
	
	
	
	public RH(String pattern)
	{
		this.pattern = pattern;
		m = pattern.length();
		Random r = new Random();
		//get a large  probable prime.
		q = BigInteger.probablePrime(32, r).longValue();
		RM = 1;
		for (int i=1;i<=m-1;i++)
			RM = RM*R;
		patHash = hash(pattern,m);
	}
	
	public long hash(String s,int m)
	{
		
		long h=0;
		for (int j=0;j<m;j++)
			h = (R*h+s.charAt(j))%q;
		return h;
	}
	
	
	public int search(String txt)
	{
		int n = txt.length();
		if (n<m)
			return -1;
		long txtHash = hash(txt,m);
		
		if (patHash==txtHash) // if the first m characters match
			return 0;
		
		//start calculating rolling hashes
		for (int j=m;j<n;j++)
		{
			//remove leading digit,add trailing digit and check for match
			txtHash = (txtHash+q - (RM*txt.charAt(j-m))%q)%q; // this line removes the leading digit
			txtHash = (txtHash*R+txt.charAt(j))%q;
			
			if (patHash==txtHash)
				return j-m+1;
		}
		
		return n; //no match
		
		
	}
	
	
	
	
	public static void main(String[]args)
	{
		String txt = "aahelloaa";
		String pattern = "hello";
		RH rh = new RH(pattern);
		System.out.println(rh.search(txt));
	}

}
