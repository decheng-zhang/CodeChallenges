/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Solution {
   public int minMeetingRooms(Interval[] intervals) 
	{
		Arrays.sort(intervals,new Comparator<Interval>()
				{
					@Override
					public int compare(Interval o1, Interval o2)
					{
						return o1.start - o2.start;
					}
				});
		
		PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>()
				{
					@Override
					public int compare(Interval o1, Interval o2)
					{
						return o1.end - o2.end;
					}
				});
		
		// invariant: size of heap denotes the minimum number of rooms required 
		// at the time. Whenever we get a new request for reservation , we dive 
		// into the heap to find the room that would become free first, if not this 
		// room then no other room in the heap can satisfy this request, so we 
		// create a new room. If the reservation request can be allocated at this room 
		// we increase the end time of the room.
		
		for (Interval i :intervals)
		{
			if (pq.isEmpty())
				pq.offer(i);
			else
			{
				Interval earliest = pq.poll();
				if (earliest.end <= i.start)
				{
					earliest.end = i.end;
				}					
				else
				{
					pq.offer(i);
				}
				pq.offer(earliest);
			}
		}
	
		return pq.size();
    }
}
