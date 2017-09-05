class Solution {
    public int getMoneyAmount(int n) {
        //bottoms up solution
        int[][]cache = new int[n+1][n+1];
        //row is start index, col is end index of the sequence.
        //represents the minimum cost to guess right for this
        //sequence from start...end
        //check discussion for details.
        for (int l=2;l<=n;l++)
        {
            //l = end-start+1 (both inclusive)
            for (int start = 1;start<=n-l+1;start++)
            {
                int min = Integer.MAX_VALUE;
                for (int chosen = start;chosen<=l+start-1;chosen++)
                {
                    cache[start][l+start-1]=Math.min(min,chosen+Math.max(chosen-1<start?0:cache[start][chosen-1],
                                                                         chosen+1>l+start-1?0:cache[chosen+1][l+start-1]));
                    min = cache[start][l+start-1];
                }
            }
        }
        return cache[1][n];
        //return for sequence starting at 1 and ending at n.   
    }
}
