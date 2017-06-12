public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length()]; 
        /*cache[i] represents if s[0...i] can be expressed as dictionary words
         than cache[0..i] = true if and only if s[0..i] is a word in dict or s[j...i] is a word in dict and cache[0..j-1] is 
         true */
         for (int i=0;i<s.length();i++)
         {
             for (int j=0;j<=i;j++)
             {
                 String substring = s.substring(j,i+1);
                 if (wordDict.contains(substring) && (j==0 || cache[j-1]))
                 {
                     cache[i]=true;
                     break;
                 }
             }
         }
         return cache[s.length()-1];
    }
}
