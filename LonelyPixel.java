public class Solution {
    LinkedList<int[]> L;
    public int findLonelyPixel(char[][] picture) {
        L = new LinkedList<>();
        int[] cols = new int[picture[0].length];
        int[] rows = new int[picture.length];
        
        for (int i=0;i<picture.length;i++)
        {
            for (int j=0;j<picture[0].length;j++)
            {
                if (picture[i][j]=='B')
                {
                    rows[i]+=1;
                    cols[j]+=1;
                    L.add(new int[]{i,j});
                }
            }
        }
        
        int lonely=0;
        
        for (int[]pair:L)
        {
            if (rows[pair[0]]==1 && cols[pair[1]]==1)
                lonely++;
        }
        return lonely;
    }
}
