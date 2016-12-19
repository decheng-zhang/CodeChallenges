public class Solution {
    int[]input;
    public boolean canJump(int[] nums) {
        input = nums;
        int left = nums.length-1;
        boolean flag = true;
        int i=0;
        while(i<nums.length)
        {
            if (nums[i]==0)
                {
                    flag = false;
                    break;
                }
            else
                {
                    i = i+nums[i];
                }
        }
        if (flag==true)
            return true;
        return jump(0,left);
    }
    
    private boolean jump(int index, int left)
    {
        if (left<=0)
            return true;
        else if (input[index]==0)
            return false;
        else
        {
            for (int i=input[index];i>=1;i--)
                {
                    if (jump(index+i,left-i))
                        return true;
                }
            return false;
        }
    }
    
}
