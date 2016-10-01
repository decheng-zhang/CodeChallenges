package trie;
import java.util.HashMap;

/* Uses Hashmap and recursive appraoch, can also do iterative*/

public class trie {
	
	public class DHM<K,V> extends HashMap<K,V>
	{
		V defval;
		public DHM(V default_val)
		{
			defval = default_val;
		}
		@Override
		public V get(Object k)
		{
			return containsKey(k)?super.get(k):defval;
		}
	}
	
	public class Tnode
	{
		boolean isLeaf;
		DHM<Character,Tnode>children;
		
		public Tnode(int alphabets,boolean leaf) //for english 26
		{
			isLeaf = leaf;
			children = new DHM<Character,Tnode>(null);
		}
	}
	
	Tnode root;
	int alphabets;
	
	public trie(int alphabets)
	{
		root = null;
		this.alphabets = alphabets;
	}
	
	public void insert(String s)
	{
		if (root == null)
			root = new Tnode(alphabets,false);
		insert(root,s,0);
	}
	
	private void insert(Tnode n, String s, int level)
	{
		char level_char = s.charAt(level);
		if (n.children.get(level_char)==null)
			{
				if (level == s.length()-1)
					n.children.put(level_char, new Tnode(alphabets,true));
				else
					n.children.put(level_char, new Tnode(alphabets,false));
					
			}
		if (level != s.length()-1)
			insert(n.children.get(level_char),s,level+1);		
		
	}
	
	public boolean search(String key)
	{
		if (root == null)
			return false;
		else
			return search(key,root,0);
	}
	
	private boolean search(String key, Tnode n,int level)
	{
		char level_char = key.charAt(level);

		if (n.children.get(level_char)==null)
			return false;
		
		else
		{
			if (level==key.length()-1 && n.children.get(level_char).isLeaf)
				return true;
			else
				return search(key,n.children.get(level_char),level+1);
		}
	}
	
	
	public static void main(String[] args)
	{
		String[] input = {"apple","orange","mango"};
		trie T = new trie(26);
		for (int i=0;i<input.length;i++)
			T.insert(input[i]);
		
		for (int i=0;i<input.length;i++)
			System.out.println(T.search(input[i]));
		
		System.out.println(T.search("guava"));
	}
	
	

}
