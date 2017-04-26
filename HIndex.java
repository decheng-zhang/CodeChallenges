import java.util.Arrays;
import java.util.Collections;
public class Solution {

	
	int[]cited;
	public int hIndex(int[] citations) {
	    if (citations.length==0)
	        return 0;
		cited = new int[citations.length+1];
		for (int i=0;i<citations.length;i++)
			{
			    if (citations[i]>=citations.length)
			        cited[cited.length-1]++;
		        else
		            cited[citations[i]]++;
			}
			
		for (int i=cited.length-1;i>=0;i--)
		{
		    if (i!=cited.length-1)
		        cited[i]+=cited[i+1];
		    if (cited[i]>=i)
		        return i;
		}
	
		return 1;
	        
	    }

}
