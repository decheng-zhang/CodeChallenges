/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        //sort the List in ascending order of start.
        intervals.sort((Interval o1, Interval o2)->o1.start-o2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((Interval o1, Interval o2)->o2.end-o1.end);
        
    for (Interval i :intervals)
       {
           if (pq.isEmpty())
                pq.offer(i);
            else
            {
                Interval largest = pq.poll();
                if (i.start <= largest.end)
                    largest.end = largest.end>i.end?largest.end:i.end;
                else
                    pq.offer(i);
                pq.offer(largest);
            }
       }
       List<Interval> result = new LinkedList<Interval>();
       int size = pq.size();
       for (int i= 0;i<size;i++)
            result.add(pq.poll());
       
       return result;
        
    }
}
