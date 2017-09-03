class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[]digit_map = new int[10];
        for (int i=0;i<nums.length;i++)
        {
            digit_map[nums[i]-'0']=i;
            
        }
        
        for (int i=0;i<nums.length;i++)
        {
            for (int j=digit_map.length-1;j>=0;j--)
            {
                if (j>Integer.valueOf(nums[i]-'0') && digit_map[j]>i)
                {
                    char temp = nums[i];
                    nums[i]=nums[digit_map[j]];
                    nums[digit_map[j]] = temp;
                    return Integer.parseInt(new String(nums));
                }
            }
        }
        return num;
    }
}
