public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0)
            return true;
        if (t.length()==0)
            return false;
            
        int counter = s.length();
        int pointer = 0;
        for (int i=0;i<t.length();i++)
            {
                if (t.charAt(i)==s.charAt(pointer))
                {
                    counter--;
                    pointer++;
                }
                if (counter == 0)
                    return true;
            }
        return false;
        
        
    }
}
