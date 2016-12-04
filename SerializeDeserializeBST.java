import java.util.HashMap;
public class TSD {
	
	static class TreeNode
	{
		int val;
		TreeNode left ;
		TreeNode right;
		TreeNode(int x)
		{
			val = x;
			
		}
	}
	
	TreeNode root = null;
	
	public void addNode(int a)
	{
		if (root == null)
			root = new TreeNode(a);
		else
			insertNode(root,a);
	}
	
	private TreeNode insertNode(TreeNode n,int val)
	{
		if (n == null)
			return new TreeNode(val);
		else
		{
			if (val > n.val)
				n.right = insertNode(n.right,val);
			else
				n.left = insertNode(n.left,val);
			return n;
		}
	}
	
	public void display()
	{
		inOrder(root);
	}
	
	private void inOrder(TreeNode n)
	{
		if (n == null )
			return;
		else
		{
			inOrder(n.left);
			System.out.println(n.val);
			inOrder(n.right);
		}
	}
	/******************Problem***************************/
	private int numNode(TreeNode n)
	{
		if (n == null)
			return 0;
		else
		{
			int left = numNode(n.left);
			int right = numNode(n.right);
			return 1+left+right;
		}
	}
	
	private void populate(TreeNode n,HashMap<Integer,Integer> H, int index)
	{
		if (n == null)
		{
			return;
		}
		else
		{
			H.put(index,n.val);
			populate(n.left,H,2*index);
			populate(n.right,H,2*index+1);
		}
	}
	public String serialize(TreeNode root)
	{
		if (root == null)
	        return "";
		HashMap<Integer,Integer>H = new HashMap<Integer,Integer>();
		populate(root,H,1);
		StringBuffer SB = new StringBuffer();
		for (int key:H.keySet())
		{
			SB.append(key+"#"+H.get(key)+" ");
		}
		String s = SB.toString();
		return s;
	}
	
	private TreeNode ds(HashMap<Integer,Integer> H, int index)
	{
		if (H.getOrDefault(index, Integer.MIN_VALUE)==Integer.MIN_VALUE)
			return null;
		else
		{
			TreeNode n = new TreeNode(H.get(index));
			n.left = ds(H,2*index);
			n.right = ds(H,2*index+1);
			return n;
		}
					
	}
	public TreeNode deserialize(String data)
	{
		String[] input = data.split(" ");
		if (input.length == 0 || data.equals(""))
		    return null;
		HashMap<Integer,Integer> H = new HashMap<Integer,Integer>();
		for (String s:input)
		{
			String[] parts = s.split("#");
			int index = Integer.parseInt(parts[0]);
			int value = Integer.parseInt(parts[1]);
			H.put(index, value);
		}
		TreeNode root = ds(H,1);
		
		
		return root;
	}
	
	public static void main(String[] args )
	{
		TSD T = new TSD();
		T.addNode(100);
		T.addNode(90);
		T.addNode(200);
		T.addNode(110);
		T.addNode(210);
		T.addNode(70);
		T.addNode(80);
		T.addNode(60);
		T.addNode(95);
		T.display();
		System.out.println(T.serialize(T.root));
		T.inOrder(T.deserialize(T.serialize(T.root)));
		System.out.println("".isEmpty());
	}

}
