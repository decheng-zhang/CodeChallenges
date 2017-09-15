class Solution {
    
    String given;
    boolean match(String word)
    {
        if (word.length()>given.length())
            return false;
        char[] src = given.toCharArray();
        char[] dst = word.toCharArray();
        int L=0;
        int R=0;
        while (L<given.length() && R<word.length())
        {
            if (src[L]==dst[R])
            {
                L++; R++;
            }
            else
                L++;
        }
        if (R==word.length())
            return true;
        else
            return false;
    }
    public String findLongestWord(String s, List<String> d) {
        
        given = s;
        
        Collections.sort(d, new Comparator<String>()
                         {
                             public int compare(String s1, String s2)
                             {
                                 if (s1.length()>s2.length())
                                     return -1;
                                 else if (s1.length()<s2.length())
                                     return 1;
                                 else
                                 {
                                     return s1.compareTo(s2);
                                 }
                             }
                         });
        for (String word:d)
        {
            if (match(word))
                return word;
        }
        return "";
    }
}
