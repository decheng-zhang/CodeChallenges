import java.util.Hashtable;
public class Solution {
	Hashtable<Integer,Integer>cache = new Hashtable<>();
	int []change;
	public int calculate(int amount)
	{
		if (cache.containsKey(amount))
			return cache.get(amount);
		else if (amount ==0 )
		{
			cache.put(amount, 0);
			return 0;
		}
		else
		{
			int value = Integer.MAX_VALUE;
			for (int i=0;i<change.length;i++)
				{
					if (amount-change[i]>=0)
					{	
            //beware of sink overflow when using Math.min, MaxVal wraps around to negative.
						int result = 1+calculate(amount-change[i]);
						if (result >=0 && result<value)
							value = result;
					}
				}
			cache.put(amount, value);
			return value;
		}
	}
	public int coinChange(int[] coins, int amount) {
			if (amount < 0 || coins.length==0)
				return -1;
	        this.change=coins;
	        int result = calculate(amount);
	        if (result!=Integer.MAX_VALUE)
	        	return result;
	        else
	        	return -1;
	        
	    }
	public static void main(String[]args)
	{
		int[]coins={186,419,83,408};
		int amount =6249;
		Solution s = new Solution();
		System.out.println(s.coinChange(coins, amount));
	}
}
