public class Solution {
    public int maxArea(int[] height) {
        
        if (height.length==0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int area;
        while (left < right)
        {
            area = (right-left)*Math.min(height[left],height[right]);
            max = area>max?area:max;
            if (height[left]>height[right])
                right--;
            else
                left++;
        }
        
        return max;
    }
}
