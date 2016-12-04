import java.util.ArrayList;
public class Heap {
	ArrayList<Integer> A = new ArrayList<Integer>();
	
	public Heap()
	{
		A.add(Integer.MIN_VALUE);
	}
	
	
	public void simple_add(int val)
	{
		A.add(val);
	}
	public void add(int val)
	{
		A.add(val);
		swim(A.size()-1);
	}
	
	public int poll()
	{
		if (A.size()==1)
			return Integer.MIN_VALUE;
		int result = A.get(1);
		A.set(1, A.get(A.size()-1));
		A.remove(A.size()-1);
		sink(1);
		return result;
	}
	
	public void Heapify() //O(nlog(n))
	{
		int mid_index = (A.size()-1)/2;
		for (int i = mid_index;i>=1;i--)
		{
			sink(i);
		}
	}
	
	private void swim(int index)
	{
		if (index <=1 )
			return;
		else
		{
			if (A.get(index)<A.get(index/2))
			{
				int temp = A.get(index);
				A.set(index, A.get(index/2));
				A.set(index/2, temp);
				swim(index/2);
			}
		}
	}
	
	private void sink(int index)
	{
		if (index >= A.size())
		{
			return;
		}
		else
		{	
			int min = Integer.MAX_VALUE;
			int nIndex = 0;
			if (2*index < A.size() && A.get(2*index)<min)
				{
					nIndex = 2*index;
					min = A.get(2*index);
				}
			if (2*index+1 < A.size() && A.get(2*index+1)<min)
				{
					nIndex = 2*index+1;
					min = A.get(2*index+1);
				}
			if (A.get(index)>min)
			{
				int temp = A.get(index);
				A.set(index, min);
				A.set(nIndex,temp);
				sink(nIndex);
			}				
		}
	}
	
	public static void main(String[] args)
	{
		Heap H = new Heap();
		H.add(52);
		H.add(98);
		H.add(20);
		H.add(5);
		H.add(2);
		
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		
		H.simple_add(52);
		H.simple_add(98);
		H.simple_add(20);
		H.simple_add(5);
		H.simple_add(2);
		H.Heapify();
		
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
		System.out.println(H.poll());
	}
	

}
