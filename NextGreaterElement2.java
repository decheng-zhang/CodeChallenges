import java.util.Stack;
import java.util.Arrays;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> S = new Stack<>();
        int len = nums.length;
        int []next = new int[len];
        Arrays.fill(next,-1);
        for (int i=len-1;i>=0;i--)
            S.push(i);
        for (int i=len-1;i>=0;i--)
        {
            int num = nums[i];
            while (!S.isEmpty() &&nums[S.peek()]<=num)
            {
                S.pop();
            }
            if (!S.isEmpty())
                next[i]=nums[S.peek()];
            S.push(i);
        }
        
        return next;
    }
}
