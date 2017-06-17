public class Solution {
    String[]map;
    
    public void dfs(List<String> result, String running, String number)
    {
        if (number.length()==0)
            result.add(running);
        else
        {
            char top = number.charAt(0);
            String temp = number.substring(1);
            for(int i=0;i<map[Character.getNumericValue(top)].length();i++)
            {
                dfs(result,running+map[Character.getNumericValue(top)].substring(i,i+1),temp);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        map = new String[]{"*","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new LinkedList<>();
        if (digits.length()==0)
            return result;
        String running=new String();
        dfs(result,running,digits);
        return result;
        
        
    }
}
