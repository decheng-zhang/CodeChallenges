class Solution {
    int climbStairs(int n) {
        int[] cache = new int[n+1];
        cache[0]=1;
        for (int i=1;i<cache.length;i++)
        {
            if (i-1>=0)
                cache[i]=cache[i-1];
            if (i-2>=0)
                cache[i]+=(cache[i-2]);
        }
        return cache[cache.length-1];
        
    }
}
