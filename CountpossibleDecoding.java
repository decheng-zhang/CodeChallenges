import java.util.Hashtable;
import java.lang.StringBuffer;
/*Count Possible Decodings of a given Digit Sequence*/
public class CPD {
	
	Hashtable<Integer,Character> M;
	int[] Input;
	public CPD(int[] Input)
	{
		this.Input = Input;
		M = new Hashtable<Integer,Character>();
		for (int i=0;i<25;i++)
		{
			M.put(i+1, (char)(65+i));
		}
	}
	
	void solve()
	{
		String S = new String("");
		sequences(S,0);
	}
	
	void sequences(String S,int index)
	{
		if (index >= Input.length)
			System.out.println(S);
		else
		{
			//choose 1
			if (index < Input.length)
			{
				S = S+(M.get(Input[index]));
				sequences(S,index+1);
			}
			//choose 2 
			if (index+1 < Input.length)
			{
				int key = 10*Input[index]+Input[index+1];
				if (key <=26)
				{
					S = S+(M.get(key));
					sequences(S,index+2);
				}
				
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] input = {1,2,3,4};
		CPD S = new CPD(input);
		S.solve();
		
	}

}
