public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0)
            return 1;
        int[] memo = new int[n];
        memo[0]=10;
        
        for (int i=1;i<n;i++)
        {
            int header = 9;
            int uniq = 9;
            int counter = i;
            while (counter-->0)
            {
                uniq=uniq*header--;
            }
            memo[i]=uniq+memo[i-1];
        }
        
        return memo[n-1];
        
    }
}
