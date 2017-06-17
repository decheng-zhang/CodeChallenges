import java.util.Random;
import java.util.Hashtable;
import java.util.ArrayList;
public class RandomizedSet {
    Hashtable<Integer,Integer> map ;//map val to location in list
    ArrayList<Integer> data;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new Hashtable<>();
        data = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val,data.size());
        data.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        if (index!=data.size()-1)
        {
            int val_at_tail = data.get(data.size()-1);
            data.set(index,val_at_tail);
            map.put(val_at_tail,index);
        }
        data.remove(data.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random R = new Random();
        int rnd_index = R.nextInt(data.size());
        return data.get(rnd_index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
