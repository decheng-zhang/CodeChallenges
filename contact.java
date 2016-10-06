import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*https://www.hackerrank.com/challenges/ctci-contacts*/

public class Solution {
    
    trie T = new trie();
    
    public class Node
        {
        Hashtable<Character,Node> lib;
        boolean leaf;
        int count;
        
        public Node()
            {
            lib = new Hashtable<Character,Node>();
            leaf = false;
            count =0;
        }
    }
    
    public class trie
        {
        Node root = new Node();
        
        private void insert(Node n, String s)
        {
            if (n.lib.containsKey(s.charAt(0)))
            {
                Node temp = n.lib.get(s.charAt(0));
                temp.count++;
                if (s.length()==1)
                {
                    //MAKE IT A LEAF NODE
                    temp.leaf = true; 
                }
                else
                {
                    //just insert string minus first character
                    insert(temp,s.substring(1));
                }
            }
            else // Node does not exists
            {
                 Node temp = new Node();
                 temp.count++;
                if (s.length()==1)
                {
                    temp.leaf = true;
                    n.lib.put(s.charAt(0),temp);
                }
                else
                {
                    n.lib.put(s.charAt(0),temp);
                    insert(temp,s.substring(1));
                }
            }
        }
        
        public void add (String s)
        {
            insert(root, s);
        }
        private int findS(Node n, String s)
        {
            if (!n.lib.containsKey(s.charAt(0)))
                return 0;
            else
            {
                if (s.length()!=1)
                    return findS(n.lib.get(s.charAt(0)),s.substring(1));
                else
                    return n.lib.get(s.charAt(0)).count;
            }
        }
        public void find(String s)
        {
            System.out.println (findS(root,s));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution M = new Solution();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add"))
            {
                M.T.add(contact);
            }
            else
                M.T.find(contact);
        }
    }
}
