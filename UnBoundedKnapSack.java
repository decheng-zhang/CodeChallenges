/*https://www.hackerrank.com/challenges/unbounded-knapsack*/

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.io.InputStreamReader;


public class Solution {
	
	static class pair 
	{
		int items;
		int weight;
		public pair(int weight, int items)
		{
			this.weight = weight;
			this.items = items;
		}
		
		public boolean equals(Object o)
		{
			pair that = (pair) o;
			if (this.weight == that.weight && this.items == that.items)
				return true;
			else
				 return false;
		}
		
		public int hashCode()
		{
			int hash = 31;
			hash += hash * this.weight;
			hash += hash * this.items;
			return hash;
		}
		
		
	}
	
	public static class KS
	{
		int[] seq;int capacity;
		Hashtable<pair,Integer> cache;
		public KS(int[]sequence,int cap)
		{
			seq = sequence;
			cap = capacity;
			cache  = new Hashtable<pair,Integer>();
			
		}
		
		public int max(int a, int b)
		{
			return a>b?a:b;
		}
		
		public int getResults(int cap,int items)
		{
			return solve(cap,items);
		}
		
		private int solve(int cap,int items)
		{
			
			if (cap ==0 || items == 0)
				return 0;
			else if (cache.containsKey(new pair(cap,items)))
			{
				return cache.get(new pair(cap,items));
			}
			else
			{
				int retval=100;
				if (seq[items-1]>cap)
					retval = solve(cap,items-1);
				else
				{
					retval = max(seq[items-1]+solve(cap - seq[items-1],items),solve(cap,items-1));
				}
				cache.put(new pair(cap,items),retval);
				
				return retval;
			}
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		//String filename = args[0];
		//BufferedReader br = new BufferedReader(new FileReader(filename));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] inputs;
		int[] sequence;
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 0;t<testCases;t++)
		{
			line = br.readLine();
			inputs = line.split(" ");
			int len_seq = Integer.parseInt(inputs[0]);
			sequence = new int[len_seq];
			int capacity = Integer.parseInt(inputs[1]);
			line = br.readLine();
			inputs = line.split(" ");
			int counter=0;
			for (String s:inputs)
			{
				sequence[counter++]=Integer.parseInt(s);
			}
			KS K = new KS(sequence,capacity);
			System.out.println(K.getResults(capacity,sequence.length));
		}
		
	}

}
