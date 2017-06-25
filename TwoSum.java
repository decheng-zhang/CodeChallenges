public class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<int[]> tracker = new ArrayList<>();
        int index=0;
        for (int num:nums)
            {
                tracker.add(new int[]{num,index++});
            }
        Collections.sort(tracker,(o1,o2)->o1[0]-o2[0]);
        int lo = 0;
        int hi = nums.length-1;
        
        while (lo < hi)
        {
            if (tracker.get(lo)[0]+tracker.get(hi)[0]==target)
                break;
            else if (tracker.get(lo)[0]+tracker.get(hi)[0]>target)
                hi--;
            else
                lo++;
        }
        
        return new int[]{tracker.get(lo)[1],tracker.get(hi)[1]};
    }
}
