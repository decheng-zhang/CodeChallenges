class Solution {
    
    int true_divisor;
    long ans;
    public void div(long dividend, long divisor, long counter)
    {
        if (divisor<= dividend)
        {
            ans+=counter;
            dividend= dividend-divisor;
            if (2*divisor <= dividend)
            {
                divisor = 2*divisor;
                counter = 2*counter;
                div(dividend,divisor,counter);
            }
            else
            {
                while (divisor>dividend)
                {
                    divisor=divisor/2;
                    counter=counter/2;
                }
                if (divisor < true_divisor)
                    return;
                div(dividend,divisor,counter);
            }
        }
        else
            return;
        
    }
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;
        true_divisor=divisor;
        ans = 0;
        long D,d;
        D = Math.abs((long) dividend);
	    d = Math.abs((long) divisor);
        boolean neg_dividend=false;
        if (dividend<0)
        {
            D = -D;
            neg_dividend = true;
        }
        boolean neg_divisor = false;
        if (d<0)
        {
            d = -d;
            neg_divisor = true;
        }
        System.out.println("D "+D+" d "+d);
        if (D<d)
            return 0;
        div(D,d,1);
        if (ans>Integer.MAX_VALUE)
            ans = Integer.MAX_VALUE;
        if (neg_dividend && neg_divisor)
            return (int)ans;
        else if (neg_divisor || neg_dividend)
            return -(int)ans;
        else
            return (int)ans;
    }
}
