class Solution {
    public double myPow(double x, int n) {
        
        if (n==0)
            return 1;
        if (x==0 || x==1 || n ==1)
            return x;
        if (x == -1)
            return (n%2==0?1.0:-1.0);
        if (n == Integer.MIN_VALUE)
            return 0.0;
        if (n<0)
        {
            n = -n;
            x = 1/x;
        }
        
        return ((n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2));
        
    }
}
