import java.util.PriorityQueue;
import java.util.ArrayList;
public class Solution {
     PriorityQueue<int[]> PQ = new PriorityQueue<>((m,n)->(m[0]+m[1]-n[0]-n[1]));
     List<int[]> L = new ArrayList<>();
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length==0||nums2.length==0)
            return L;
       
        for (int i=0;i<nums1.length;i++)
        {
            PQ.offer(new int[]{nums1[i],nums2[0],i,0});
        }
        while(k>0&&(!PQ.isEmpty()))
        {
            int[] cas = PQ.poll();
            L.add(new int[]{cas[0],cas[1]});
            k--;
            if (cas[3]>=nums2.length-1)
                continue;
            PQ.offer(new int[]{nums1[cas[2]],nums2[cas[3]+1],cas[2],cas[3]+1});
        }
        return L;
    }
}
