public class ZigzagIterator {
    int index1,index2;
    boolean flag;
    List<Integer> v1,v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) 
    {
        this.v1 = v1;
        this.v2 = v2;
        index1=0;
        index2=0;
        flag = true;
    }

    public int next() {
        if (flag)
            {
                if (index1<v1.size())
                {
                    flag = false;
                    return v1.get(index1++);
                }
                else
                {
                    flag = false;
                    return v2.get(index2++);
                }
            }
        else
        {
            if (index2<v2.size())
                {
                    flag = true;
                    return v2.get(index2++);
                }
                else
                {
                    flag = true;
                    return v1.get(index1++);
                }
        }
    }

    public boolean hasNext() {
        if (index1<v1.size() || index2<v2.size())
            return true;
        else
            return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
