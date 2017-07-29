import java.util.Deque;
import java.util.LinkedList;
import java.util.HashMap;
public class LRUCache {
    private class item
    {
        int key,val;
        public item(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
        
        @Override
        public boolean equals(Object o)
        {
            if (!(o instanceof item))
                return false;
            item temp = (item)o;
            if (temp.key == this.key)
                return true;
            else
                return false;
        }
    }
    HashMap<Integer,item> map = new HashMap<>();
    Deque<item> cache = new LinkedList<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key))
        {
            int val = map.get(key).val;
            cache.remove(map.get(key));
            cache.addFirst(map.get(key));
            return val;
        }
        
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            map.get(key).val = value;
            cache.remove(map.get(key));
            cache.addFirst(map.get(key));
            return;
        }
        if (cache.size() == capacity)
        {
            int last_key = cache.removeLast().key;
            map.remove(last_key);
        }
        item temp = new item(key,value);
        cache.addFirst(temp);
        map.put(key,temp);
    }
}
