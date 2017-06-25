
//http://keithschwarz.com/interesting/code/?dir=find-duplicate

public class Solution {
    public int findDuplicate(int[] nums) {
        
        int faster = 0;
        int slower = 0;
        
        while (true)
        {
            faster = nums[nums[faster]];
            slower = nums[slower];
            
            if (faster == slower)
                break;
        }

        int finder = 0;
        
        while (true)
        {
            finder = nums[finder];
            slower = nums[slower];
            
            if (finder == slower)
                break;
        }
        
        return finder;
    }
}
