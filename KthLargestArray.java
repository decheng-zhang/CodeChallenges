public class Solution {
    
    public int partition(int[] data, int start, int end)
	{
	    if (end-start==0)
			return end;
		int pivot = data[start];
		int left = start;
		int right = end+1;
		while (left < right)
		{
			while (data[++left]<pivot)
				{
				if (left==end)
					break;
				}
			while(data[--right]>pivot)
				{
					if (right==start)
						break;
				}
			if (left>=right)
				break;
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;
		}
		
		data[start] = data[right];
		data[right] = pivot;
		
	
		return right;
	}
	
   public int QS(int[]input, int start, int end, int k)
	{
		int index = partition(input,start, end);
	
		if (index == k)
			return input[index];
		else if (index > k)
		{
			return QS(input, start, index-1 , k);
		}
		else
			return QS(input,index+1,end,k);
	}
	
	
	
    public int findKthLargest(int[] nums, int k) {
    	int rank = nums.length-k;
        return QS(nums,0,nums.length-1,rank);
    }
}
