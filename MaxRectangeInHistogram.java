import java.util.Stack;
public class Solution {
    Stack<Integer> S = new Stack<>();
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        S.push(-1);
        int maxArea = Integer.MIN_VALUE;
        for (int i=0;i<heights.length;i++)
        {
            while (S.peek()!=-1 && heights[S.peek()]>=heights[i] )
            {
                int area = heights[S.pop()]*(i-1-S.peek());
                maxArea = maxArea>area?maxArea:area;
            }
            S.push(i);
        }
        while (S.peek()!=-1)
        {
            maxArea = Math.max(maxArea, heights[S.pop()]*(heights.length-S.peek()-1));
        }
        return maxArea;
        
    }
}
