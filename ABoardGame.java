/**/
	
	public class ABoardGame {
		
		String[] input;
		char[][]board;
		int[]Ra;
		int[]Rb;
		public String whoWins(String[] input)
		{
	        this.input = input;
			board = new char[input.length][input[0].length()];
			for (int i =0;i<input.length;i++)
			{
				for (int j =0;j<input[0].length();j++)
				{
					board[i][j]=input[i].charAt(j);
				}
			}
			//initialize regfion records
			Ra = new int[input.length/2+1];
			Rb = new int[input.length/2+1];
			Ra[0]=0;Rb[0]=0;
			int start_index=0;
			int end_index =input.length-1;
			int median = start_index + (end_index - start_index)/2;
			int region = 1;
			int region_start_index = median;
			int region_end_index = median+1;
			int Alice=0;
			int Bob=0;
			while (region_start_index>=0 && region_end_index < input.length)
				{
					
						if (winner(region_start_index,region_end_index,region).equals("Bob"))
							return "Bob";
						else if (winner(region_start_index,region_end_index,region).equals("Alice"))
							return "Alice";
						else
						{
							region_start_index--;
							region_end_index++;
							region++;
						}
				}
			return "Draw";
			}
			
		
		
		public String  winner(int start,int end,int region)
		{
			System.out.println(start+" "+end);
			int Alice=0,Bob=0;
			int Alice_prev=0,Bob_prev=0;
			//calcxulate data for previous regions
			for (int k =0;k<region;k++)
			{
				Alice_prev+=Ra[k];
				Bob_prev+=Ra[k];
			}
			for (int i = start;i<=end;i++)
			{
				for (int j = start;j<=end;j++)
				{
					if (board[i][j]=='A')
						Alice++;
					else if (board[i][j]=='B')
						Bob++;
						
				}
			}
			//subtract count from previous regions
			Alice-=Alice_prev;
			Bob-=Bob_prev;
			//add record for new region
			Ra[region]=Alice;
			Rb[region]=Bob;
			if (Alice==Bob)
				return "draw";
			else if (Alice>Bob)
				return "Alice";
			else
				return "Bob";
		}	
	
	
	public static void main(String[] args)
	{
		String[] input = {"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"};
		ABoardGame W = new ABoardGame();
		System.out.println(W.whoWins(input));
		for (int i=0;i<W.Ra.length;i++)
			System.out.println(W.Ra[i]+" "+W.Rb[i]);
	}
		
		
		

	}

