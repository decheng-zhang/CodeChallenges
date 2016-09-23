import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class xortholian {
	
	public String otherInput(String output_color, String input_color)
	{
		switch(output_color)
		{
		case "red":
			return (input_color.equals("red")?"blank":"red");
		case "orange":
			return (input_color.equals("red")?"yellow":"red");
		case "yellow":
			return (input_color.equals("yellow")?"blank":"yellow");
		case "green":
			return (input_color.equals("yellow")?"blue":"yellow");
		case "blue":
			return (input_color.equals("blue")?"blank":"blue");
		case "purple":
			return (input_color.equals("red")?"blue":"red");
		default:
			{
				return "";
			}	
		}
	}
	
	public static void main(String[] args) throws IOException,FileNotFoundException
	{
		xortholian X = new xortholian();
		String filename = args[0];
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			line=br.readLine();
		}
		String[] lineTwo = line.split(" ");
		String[] lineOne = new String[lineTwo.length];
		//First color is same
		lineOne[0] = lineTwo[0];
		for (int i = 1;i<lineTwo.length;i++)
		{
			lineOne[i] = X.otherInput(lineTwo[i], lineOne[i-1]);
		}
		StringBuilder S = new StringBuilder();
		for (int i = 0;i<lineOne.length-1;i++)
			S.append(lineOne[i]+ " ");
		System.out.println(S);
	}
}
