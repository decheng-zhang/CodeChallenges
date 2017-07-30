import java.util.TreeSet;
import java.util.HashMap;
public class LFUCache {
    HashMap<Integer,item>map;
    TreeSet<item> cache;
    int capacity;
    int timer = 0;
    private class item implements Comparable
    {
        int key, val, priority;
        long time;
        public item(int k,int v)
        {
            key = k;
            val = v;
            priority = 1;
            time = 0;
        }
        
        public int compareTo(Object o)
        {
            item t = (item)o;
            
            if (this.priority == t.priority)
                return ((int)(this.time - t.time));
            return (this.priority-t.priority);
        }
        
        public boolean equals(Object o)
        {
            item temp = (item)o;
            return temp.key == this.key;
        }
    }
    public LFUCache(int capacity) {
        map = new HashMap<>();
        cache = new TreeSet<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity==0)
            return -1;
        if (map.containsKey(key))
        {
            item temp = map.get(key);
            cache.remove(temp);
            temp.priority +=1;
            temp.time = ++timer;
            cache.add(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (map.containsKey(key))
        {
            item temp = map.get(key);
            cache.remove(temp);
            temp.val=value;
            temp.priority +=1;
            temp.time = ++timer;
            cache.add(temp);
            return;
        }
        if (cache.size()==capacity)
        {
            // for (item i:cache)
            //     System.out.print(i.key+","+i.priority+" ");
            //System.out.println();
            item pop = cache.pollFirst();
            map.remove(pop.key);
            //System.out.println("removed "+pop.key+" priority "+pop.priority);
        }
        item temp = new item(key,value);
        temp.time = ++timer;
        map.put(key,temp);
        cache.add(temp);
        //System.out.println("added "+key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
