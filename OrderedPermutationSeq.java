package permuationSequence;
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
	
	int[] fact;
	int rank;
	StringBuffer x;
	 public String getPermutation(int n, int k) {
		 	fact = new int[n+1];
		 	rank = k;
		 	x = new StringBuffer();
		 	fact[0]=1; fact[1]=1;
		 	for (int i = 2;i<fact.length;i++)
		 	{
		 		fact[i] = i*fact[i-1];
		 	}
		 	ArrayList<Integer> input = new ArrayList<Integer>();
		 	for (int i=1;i<=n;i++)
		 		input.add(i);
		 	int counter=0;
		 	int index;
		 	int ppd;
		 	while (rank>1)
		 	{
		 		Collections.sort(input);
		 		ppd = fact[input.size()]/input.size();
		 		index =rank/ppd;
		 		if (rank > index*ppd)
		 		{
		 			x.append(input.get(index).toString());
		 			input.remove(index);
		 			rank=rank-(ppd)*index;
		 		}
		 		else
		 		{
		 			x.append(input.get(index-1).toString());
		 			input.remove(index-1);
		 			rank=fact[input.size()];
		 		}
		 		
		 	}
		 	while (input.size()>0)
		 	{
		 		Collections.sort(input);
		 		x.append(input.get(0).toString());
		 		input.remove(0);
		 		
		 	}
	        return x.toString();
	    }
	 
	 public static void main(String[] args)
	 {
		 Solution s = new Solution();
		 System.out.println(s.getPermutation(3, 5));
	 }

}
