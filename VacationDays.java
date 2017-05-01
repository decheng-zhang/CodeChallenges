
public class Solution {
	int[][]vac;
	public int maxVacationDays(int[][] flights, int[][] days) {
			if (flights.length==0 || days.length==0)
				return 0;
			int numCities = flights.length;
			int numWeeks = days[0].length;
			vac = new int[numWeeks][numCities];
			int curr = 0;
			for (int i =0;i<numWeeks;i++)
			{
				for (int j = 0;j<numCities;j++)
				{
					if (i==0)
					{
						if (j==0 || flights[0][j]==1)
							vac[i][j]=days[j][i];
						else
							vac[i][j]=Integer.MIN_VALUE;
					}
					else
					{
						vac[i][j]=Integer.MIN_VALUE;
						for (int k=0;k<numCities;k++)
						{
							if (k!=j && flights[k][j]==0)
								continue;
							else
								{
									vac[i][j]=Math.max(vac[i][j],vac[i-1][k]+days[j][i]);
								}
						}
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i=0;i<numCities;i++)
			{
				max= vac[numWeeks-1][i]>max?vac[numWeeks-1][i]:max;
			}
			System.out.println(max);
			for (int i=0;i<vac.length;i++)
			{
				System.out.println("");
				for (int j=0;j<vac[0].length;j++)
					System.out.print(vac[i][j]+"/");
			}
			return max;
	        
	    }
	
	public static void main(String[] args)
	{
//		int [][]flights = {{0,1,1},{1,0,1},{1,1,0}};
//		int [][]days = {{1,3,1},{6,0,3},{3,3,3}};
//		int [][]flights = {{0}};
//		int [][]days = {{1}};
		int [][]flights = {{0,0,0},{0,0,0},{0,0,0}};
		int [][]days = {{1,1,1},{7,7,7},{7,7,7}};
		Solution s = new Solution();
		s.maxVacationDays(flights, days);
	}

}
