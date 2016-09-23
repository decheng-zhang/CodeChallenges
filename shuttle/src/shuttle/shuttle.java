package shuttle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class shuttle {
	
	
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		String filename = args[0];
		BufferedReader br = new BufferedReader(new FileReader(filename));
		ArrayList<String>input = new ArrayList<String>();
		ArrayList<Double> walk = new ArrayList<Double>();
		ArrayList<Double> shuttle = new ArrayList<Double>();
		String line;
		int currLine=0;
		while ((line = br.readLine())!=null)
		{
			input.add(line);
		}
		int numPaths = Integer.parseInt(input.get(0));
		currLine++;
		for (int i = 0;i<numPaths;i++)
		{
			String src = input.get(currLine).split(" ")[0];
			String dst = input.get(currLine).split(" ")[1];
			currLine++;
			int numEdges = Integer.parseInt(input.get(currLine));
			currLine++;
			graph g = new graph();
			for (int j =0;j<numEdges;j++)
			{
				String e_src = input.get(currLine).split(" ")[0];
				String e_dst = input.get(currLine).split(" ")[1];
				double e_weight = Double.parseDouble(input.get(currLine).split(" ")[2]);
				currLine++;
				if (!g.containsV(e_src))
					g.addV(e_src);
				if (!g.containsV(e_dst))
					g.addV(e_dst);
				g.addEdge(e_src, e_dst, e_weight);
			}
			dijikstra d = new dijikstra(g,src);
			walk.add(d.getDistance(dst));
			shuttle.add(Double.parseDouble(input.get(currLine++)));
		}
		for (int i = 0;i<numPaths;i++)
		{
			System.out.println("Case #"+i+": "+(walk.get(i)<shuttle.get(i)?walk.get(i):shuttle.get(i))+" "+(walk.get(i)<shuttle.get(i)?"Walk":"Shuttle"));
		}
	}

}
