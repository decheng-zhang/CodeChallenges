//https://www.hackerrank.com/challenges/self-balancing-tree
public class avl {

private class Node {
	int val;
	Node left,right;
	int ht;
	
	public Node(int val)
	{
		left = null;
		right = null;
		ht = 0;
		this.val = val;
	}

}
	
	Node root;
	public avl()
	{
		root = null;
	}
	
	public int height(Node n)
    {
		if (n==null)
			return 0;
		else if (n.left == null && n.right == null)
            return 1;
        else
            {
            int lh = height(n.left);
            int rh = height(n.right);
            return lh>rh?lh+1:rh+1;
        }
    }
	public int BF(Node n)
        {
        return height(n.left)-height(n.right);
    }

    public Node rotateleft(Node n)
        {
    	System.out.println("rotating left "+n.val);
        Node temp = n;
        n = n.right;
        temp.right = n.left;
        n.left = temp;
        return n;
    }

    public Node rotateright(Node n)
        {
    	System.out.println("rotating right "+n.val);
        Node temp = n;
        n = n.left;
        temp.left = n.right;
        n.right = temp;
        return n;
    }

    public Node balance(Node n)
    {
        if (BF(n)<=1 && BF(n)>=-1)
            return n;
        else if (BF(n)>1) // LR,LL cases
        {
            if (BF(n.left)<=-1) //LR case
                {
                n.left = rotateleft(n.left);
                return rotateright(n);
            }
            else //LL case
                return rotateright(n);
        }
        else // RL,RR case
            {
            if (BF(n.right)>=1)
                {
                n.right = rotateright(n.right);
                return rotateleft(n);
            }
            else //RR
                return rotateleft(n);
        }
    }
    
    public void  insert(int val)
    {
    	root = insert(root,val);
    }

   public Node insert(Node root,int val)
    {
       if (root == null)
       {return new Node(val);
        //root.left = null;root.right=null;root.ht=0;root.val=val;
       }
       else
           {
           if (val >= root.val)
               root.right = insert(root.right,val);
           else
               root.left= insert(root.left,val);
           return balance(root);  
       }
    }
   
   public void inorder(Node n)
   {
	   if (n==null)
		   return;
	   else
		   {	
		   		inorder(n.left);
		   		System.out.println(BF(n));
		   		inorder(n.right);
		   }
	   
   }
   
   public static void main(String[] args)
   {
	   avl A= new avl();
	   A.insert(14);
	   A.insert(25);
	   A.insert(21);
	   A.insert(10);
	   A.insert(23);
	   A.insert(7);
	   A.insert(26);
	   A.insert(12);
	   A.insert(30);
	   A.insert(16);
	   A.insert(19);
	   A.inorder(A.root);
   }

}
