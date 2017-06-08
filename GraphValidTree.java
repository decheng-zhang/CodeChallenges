public class Solution {
    int[][]graph;
    int[]inStack;
    int[]visited;
    boolean cycle = false;
    
    public void dfs(int v,int parent)
    {
        inStack[v]=1;
        visited[v]=1;
        for (int i=0;i<graph[v].length;i++)
        {
            
            if (i != parent && graph[v][i]==1 && inStack[i]==1)
                {
                    cycle = true;
                    return;
                }
            if (graph[v][i]==1 && visited[i]==0)
                dfs(i,v);
        }
        inStack[v]=0;
    }
    public boolean validTree(int n, int[][] edges) {
      
        
        if (edges.length==0 && n>1)
            return false;
        graph = new int[n][n];
        inStack = new int[n];
        visited = new int[n];
        
        for (int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]][edges[i][1]]=1;
            graph[edges[i][1]][edges[i][0]]=1;
        }
        
        dfs(0,-1);
        
        for (int i=0;i<n;i++)
            {
                if (visited[i]==0)
                    return false;
            }
            
        return !cycle;
        
    }
}
