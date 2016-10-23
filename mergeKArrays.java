package mergeKarrays;
import java.util.PriorityQueue;
public class mkA {
	
	private class node implements Comparable<node>
	{
		int arrID;
		int val;
		int index;
		
		public node(int arrID,int index,int val)
		{
			this.arrID = arrID;
			this.val = val;
			this.index = index;
		}
		
		public int compareTo(node that)
		{
			if (this.val > that.val)
				return 1;
			else if (this.val < that.val)
				return -1;
			else
				return 0;
		}		
	}
	
	PriorityQueue<node> PQ = new PriorityQueue<node>();
	
	public void merge(int[]A, int[]B, int[]C)
	{
		int sizeA = A.length;
		int sizeB= B.length;
		int sizeC = C.length;
		
		int[]mergeArray = new int[sizeA+sizeB+sizeC];
		int mergeSizeCounter = 0;
		int Acounter=0,Bcounter=0,Ccounter=0;
		PQ.add(new node(0,0,A[0]));
		PQ.add(new node(1,0,B[0]));
		PQ.add(new node(2,0,C[0]));
		while (mergeSizeCounter < sizeA+sizeB+sizeC)
		{
			
			//pick out minimum element from PQ
			node temp = PQ.remove();
			mergeArray[mergeSizeCounter++]=temp.val;
			switch(temp.arrID){
			case 0:
				if (temp.index+1 < A.length)
					PQ.add(new node(0,temp.index+1,A[temp.index+1]));
				break;
			case 1:
				if (temp.index+1 < B.length)
					PQ.add(new node(1,temp.index+1,B[temp.index+1]));
				break;
			case 2:
				if (temp.index+1 < C.length)
					PQ.add(new node(2,temp.index+1,C[temp.index+1]));
				break;
			default:
				break;	
			}
			
		}
		
		for (int i=0;i< mergeArray.length;i++)
		{
			System.out.println(mergeArray[i]);
		}
		
	}
	
	public static void main(String[] args)
	{
		int[]A = {4,5,6,7};
		int[]B = {8,9,10,11};
		int[]C = {1,2,3};
		mkA mk = new mkA();
		mk.merge(A, B, C);
	}
	
	

}
