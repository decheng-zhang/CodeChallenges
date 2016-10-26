import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class Main {
	
	public static void bfs(char origin,HashMap<Character,ArrayList<Character>> adjlist,HashMap<Character,Character> seen)
	{
		 if (seen.get(origin)!='$')
			 return;
		 else
		 {
			 Queue<Character> Q = new LinkedList<Character>(); 
			 seen.put(origin, origin);
			 Q.add(origin);
			 while (!Q.isEmpty())
			 {
				 char v = Q.poll();
				 for (char dst:adjlist.get(v))
				 {
					 if (seen.get(dst)=='$')
					 {
						 seen.put(dst, origin);
						 Q.add(dst);
					 }
				 }
			 }
			 
		 }
		
	}
	
	public static void main(String[] args) throws IOException,FileNotFoundException
	{
		//String filename = args[0];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader(filename));

		int numTests = Integer.parseInt(br.readLine());
		int baseVID = 65;
		br.readLine();//skip this space
		String line;
		for (int i=0;i<numTests;i++)
		{
			int numNodes = (int)br.readLine().toCharArray()[0]-65+1;
			
			
			HashMap<Character,ArrayList<Character>> adjlist = new HashMap<Character,ArrayList<Character>>();
			HashMap<Character,Character> seen = new HashMap<Character,Character> ();

			for (int count=0;count<numNodes;count++)
			{
				adjlist.put((char)(baseVID+count), new ArrayList<Character>());
				seen.put((char)(baseVID+count),'$');
			}
			while ((line = br.readLine()) != null)
			{
				if (line.isEmpty())
					break;
				char[] vertices = line.toCharArray();
				char src = vertices[0];
				char dst = vertices[1];
				adjlist.get(src).add(dst);
				adjlist.get(dst).add(src);
			}
			

			
//			for (char key:adjlist.keySet())
//			{
//				System.out.print(key);
//				for (char dst:adjlist.get(key))
//					System.out.print(" "+dst);
//				System.out.println();
//			}
			
			for (char key:adjlist.keySet())
			{
				bfs(key,adjlist,seen);
			}
			
//			for (char key:seen.keySet())
//			{
//				System.out.println(key+" "+seen.get(key));	
//			}
			
			System.out.println(new HashSet<Character>(seen.values()).size()+"\n");
			
		}
		
		
	}

}
