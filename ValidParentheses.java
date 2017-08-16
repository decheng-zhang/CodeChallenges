import java.util.Stack;
public class Solution {
    Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {
        
        for (int i=0;i<s.length();i++)
        {
            switch(s.charAt(i))
            {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.size()==0 || stack.pop()!='(')
                        return false;
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if (stack.size()==0 || stack.pop()!='{')
                        return false;
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (stack.size()==0 || stack.pop()!='[')
                        return false;
                    break;
                    
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
        
    }
}
