class MovingAverage {

    /** Initialize your data structure here. */
    double sum = 0;
    int count = 0;
    int size = 0;
    int[] store;
    public MovingAverage(int size) {
        this.size = size;
        store = new int[size];
    }
    
    public double next(int val) {
        if (count < size)
        {
            store[count] = val;
            count = count+1;
            sum = sum+val;
            return sum/count;
        }
        else
        {
            count=count+1;
            sum = sum - store[0] + val;
            for (int i =1;i<store.length;i++)
                store[i-1]= store[i];
            store[store.length-1] = val;
            return sum/size;
        }
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
