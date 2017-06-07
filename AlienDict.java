import java.util.Hashtable;
import java.util.Stack;
import java.util.LinkedList;
public class Solution {
    
    Hashtable<Character,List<Character>> Graph;
    Hashtable<Character,Boolean>inStack;
    Hashtable<Character,Boolean>visited;
    Stack<Character> stack;
    Boolean cycle=false;
    
    public char[] first_diff(String s1, String s2)
    {
        if (s2.startsWith(s1))
            return (new char[]{s1.charAt(s1.length()-1),'*'});
        int i=0;int j=0;
        while (s1.charAt(i)==s2.charAt(j))
            {
                i++;j++;
            }
        return new char[]{s1.charAt(i),s2.charAt(j)};
    }
    
    public void dfs(char v)
    {
        visited.put(v,true);
        inStack.put(v,true);
        for (char dst:Graph.get(v))
        {
            if (inStack.containsKey(dst) && inStack.get(dst))
            {
                cycle = true;
                return;
            }
            if (!visited.containsKey(dst))
                dfs(dst);
        }
        inStack.put(v,false);
        stack.push(v);
    }
    public String alienOrder(String[] words) {
        if (words.length==0)
            return "";
        Graph = new Hashtable<>();
        inStack = new Hashtable<>();
        visited = new Hashtable<>();
        stack = new Stack<>();
        
        for (int i=0;i<words.length;i++)
        {
            for (char c:words[i].toCharArray())
            {
                 if (!Graph.containsKey(c))
                    Graph.put(c,new LinkedList<Character>());
            }
        }
        
        for (int i=0;i<words.length-1;i++)
        {
            char[] temp = first_diff(words[i],words[i+1]);
            
            if (temp[1]!='*')
            {   
                System.out.println(temp[0]+"->"+temp[1]);
                Graph.get(temp[0]).add(temp[1]);
            }
        }
        
        for (char v:Graph.keySet())
        {
            if (!visited.containsKey(v))
                dfs(v);
            if (cycle)
                return "";
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty())
        {
            s.append(stack.pop());
        }
        return s.toString();
    }
}
