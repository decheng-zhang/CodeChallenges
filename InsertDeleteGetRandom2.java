import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashSet;

public class RandomizedCollection {

    Hashtable<Integer,HashSet<Integer>> map;
    ArrayList<Integer> data;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new Hashtable<>();
        data = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val))
            {
                HashSet<Integer> H = new HashSet<>();
                H.add(data.size());
                data.add(val);
                map.put(val,H);
                return true;
            }
        HashSet H = map.get(val);
        H.add(data.size());
        data.add(val);
        return false;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index!=data.size()-1)
        {
            int temp = data.get(data.size()-1);
            data.set(index,temp);
            map.get(temp).remove(data.size()-1);
            map.get(temp).add(index);
            
        }
        data.remove(data.size()-1);
        if (map.get(val).size()==0)
            map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        java.util.Random R = new java.util.Random();
        return data.get(R.nextInt(data.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
