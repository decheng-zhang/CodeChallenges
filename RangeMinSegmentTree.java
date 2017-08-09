
public class SegTree {
	
	
	int[] store;
	public SegTree(int[] input)
	{
		//calculate size of store
		int height = (int) Math.ceil(Math.log(input.length)/Math.log(2));
		int leaveNodes = (int)Math.pow(2, height);
		int totalNodes = 2*leaveNodes-1;
		store = new int[totalNodes];
		construct(input, 0, input.length-1,0);
	}
	
	public int construct(int[] input,int start, int end, int current)
	{
		if (start == end)
			{
				store[current]=input[start];
				return store[current];
			}
		else
		{
			int mid = start+(end-start)/2;
			int fromLeft = construct(input,start,mid,2*current+1);
			int fromRight = construct(input,mid+1,end,2*current+2);
			store[current] = Math.min(fromLeft, fromRight);
			return store[current];
		}
	}
	
	public int query(int qs, int qe, int[]input)
	{
		return query(qs, qe, 0, input.length-1, 0);
	}
	
	public void update(int pos, int newval, int[] input)
	{
		update(pos,newval,0,input.length,0);
	}
	
	public int update(int pos, int newval, int qs, int qe, int current)
	{
		if (qs == qe && qs==pos)
		{
			store[current]=newval;
			return store[current];
		}
		else if (qe<pos || pos < qs)
		{
			return store[current];
		}
		else
		{
			int mid = qs + (qe-qs)/2;
			store[current]= Math.min(update(pos, newval,qs,mid,2*current+1),update(pos,newval,mid+1,qe,2*current+2));
			return store[current];
		}
	}
	
	public int query(int qs, int qe, int ss, int se, int current)
	{
		if (se<qs || ss > qe || qs>qe)
		{
			return Integer.MAX_VALUE;
		}
		//base case segment lies inside query range.
		else if (qs<=ss && qe>=se)
		{
			return store[current];
		}
		else
		{
			int mid = ss+(se-ss)/2;
			return Math.min(query(qs,qe,ss,mid,2*current+1), query(qs,qe,mid+1,se,2*current+2));
		}
	}
	
	public void display()
	{
		for (int i=0;i<store.length;i++)
			System.out.print(i+"\t");
		System.out.println();
		for (int i=0;i<store.length;i++)
			System.out.print(store[i]+"\t");
	}
	
	public static void main(String[] args)
	{
		int[]input = new int[]{9,2,6,3,1,5,0,7};
		SegTree st = new SegTree(input);
		st.display();
		System.out.println("\nMin query test:"+st.query(2, 7,input));
		st.update(6,-10,input);
		st.display();
		System.out.println("\nMin query test:"+st.query(2, 7,input));
		
	}

}
