import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
class Solution {
    Hashtable<Integer,Integer> H = new Hashtable<>();
    int[][]people;
    public void swapRight(int start, int times)
    {
        //System.out.println("swap "+people[start][0]+","+people[start][1]+", times "+ times);
        if (times==0)
            return;
        else
        {
            int[]temp=new int[2]; 
            temp = people[start];
            people[start]=people[start+1];
            people[start+1]=temp;
            swapRight(start+1,times-1);
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>()
                    {
                        public int compare(int[] a1, int[]a2)
                        {
                            if (a1[0]!=a2[0])
                                return a1[0]-a2[0];
                            else
                                return a1[1]-a2[1];
                        }
                    });
        this.people = people;
        
        //for (int i=0;i<people.length;i++)
            //System.out.println("["+people[i][0]+", "+people[i][1]+"]");
        
        for (int i=0;i<people.length;i++)
        {
            if (!H.containsKey(people[i][0]))
                H.put(people[i][0],1);
            else
            {
                int val = H.get(people[i][0]);
                H.put(people[i][0],val+1);
            }
        }       
        
        for (int i = people.length-1;i>=0;i--)
        {
            int val = H.get(people[i][0]);
            val = val-1;
            //System.out.println("Cardinality "+people[i][0]+", "+val);
            //System.out.println("putting into table at key "+people[i][0]+"-> "+val);
            H.put(people[i][0],val);
            swapRight(i,people[i][1]-val);
           
        }
        
        //for (int i=0;i<people.length;i++)
            //System.out.println("["+people[i][0]+", "+people[i][1]+"]");
        
        return people;
        
        
    }
}
