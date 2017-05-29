public class Solution {
    
    int[] visited;
    int[] inStack;
    int[][]graph;
    boolean flag = false;
    public void dfs(int vert)
    {
            visited[vert]=1;
            inStack[vert]=1;
            for (int i=0;i<graph[0].length;i++)
            {
                if (graph[vert][i]==1 && inStack[i]==1)
                {
                    flag = true;
                    return;
                }
                if (graph[vert][i]==1 && visited[i]!=1)
                    dfs(i);
            }
            inStack[vert]=0;
            
    }
    
    public void topological_sort()
    {
        for (int i=0;i<visited.length;i++)
        {
            if (visited[i]==0)
            {
                dfs(i);
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        visited = new int[numCourses];
        inStack = new int[numCourses];
        graph = new int[numCourses][numCourses];
        for (int i=0;i<prerequisites.length;i++)
        {
            for (int j=0;j<prerequisites[0].length;j++)
            {
                graph[prerequisites[i][1]][prerequisites[i][0]]=1;
            }
        }
        topological_sort();
        if (flag)
            return false;
        else
            return true;
    }
}
