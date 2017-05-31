import java.util.ArrayList;
public class Solution {
    
    int[][]graph;
    int[]schedule;
    int[]inStack;
    int[]visited;
    int next=0;
    int flag=0;
    
    public void dfs(int v)
    {
      
        inStack[v]=1;
        visited[v]=1;
        for (int i=0;i<graph[0].length&&flag==0;i++)
        {
            if (graph[v][i]==1)
            {
                if (inStack[i]==1)
                {
                    flag = 1;
                    return;
                }
                if (visited[i]==0)
                    dfs(i);
            }
        }
        inStack[v]=0;
        schedule[next--]=v;
    }
    
    public void topologySort()
    {
        for (int i=0;i<visited.length;i++)
        {
            if (visited[i]==0)
                dfs(i);
            if (flag==1)
                return;
        }
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        schedule = new int[numCourses];
        visited = new int[numCourses];
        inStack = new int[numCourses];
        next = schedule.length-1;
        if (numCourses==0)
            return new int[0];
        graph = new int[numCourses][numCourses];
        for (int i=0;i<prerequisites.length;i++)
        {
                graph[prerequisites[i][1]][prerequisites[i][0]]=1;
        }
        topologySort();
        if (flag==1)
            return (new int[0]);
        else
            return schedule;
        
    }
}
