import java.lang.StringBuffer;
import java.util.ArrayList;
class Solution {
    ArrayList<String> solution = new ArrayList<>();
    public void recurse(StringBuffer S,int open, int open_left, int close_left)
    {
        if (open_left==0 && close_left==0)
        {
            solution.add(S.toString());
            return;
        }
       
        if (open_left!=0)
        {
            S.append('(');
            recurse(S,open+1,open_left-1,close_left);
            S.deleteCharAt(S.length()-1);
        }
        if (open!=0 && close_left!=0)
        {
            S.append(')');
            recurse(S,open-1,open_left,close_left-1);
            S.deleteCharAt(S.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        if (n==0)
        {
            solution.add("");
            return solution;
        }
        else
        {
            StringBuffer S = new StringBuffer();
            S.append('(');
            recurse(S,1,n-1,n);
        }
        return solution;
    }
}
