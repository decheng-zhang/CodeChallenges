public class Solution {
    
    int[]visited;
    int[][]graph;
    
    public void bfs(int v)
    {
        Queue<Integer> Q = new LinkedList<>();
        visited[v]=1;
        Q.offer(v);
        while (!Q.isEmpty())
        {
            int other_end = Q.poll();
            for (int i=0;i<graph[other_end].length;i++)
            {
                if (graph[other_end][i]==1 && visited[i]!=1)
                {
                    visited[i]=1;
                    Q.offer(i);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        visited = new int[n];
        graph = new int[n][n];
        int counter=0;
        for (int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]][edges[i][1]]=1;
            graph[edges[i][1]][edges[i][0]]=1;
        }
        
        for (int i=0;i<n;i++)
        {
            if (visited[i]==0)
            {
                counter++;
                bfs(i);
            }
        }
        
        return counter;
    }
}
