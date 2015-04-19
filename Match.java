import java.awt.Color;
import java.util.ArrayList;

public class Match 
{
	static int g;
	static int s;
	static int whiteCounter = 0;
	static int blackCounter = 0;

	public static void hint(ArrayList<Pin> guess, ArrayList<Pin> solution)
	{
		for(int x = 0; x < guess.size(); x++)
		{
			if(guess.get(x).getColor().equals(solution.get(x).getColor()) && (guess.get(x).getIndex() == solution.get(x).getIndex()))
			{
				blackCounter++;
				guess.remove(x);
				solution.remove(x);
				x = 0;
			}
			else 
			{
				int counter = 0;
				int gCurrent = 0;
				int sCurrent = 0;
				for ( g = 0; g < guess.size(); g++)
				{
					for ( s = 0; s < solution.size(); s++)
					{
						if(guess.get(g).getColor().equals(solution.get(s).getColor()))
						{
							counter++;
							gCurrent = g;
							sCurrent = s;
						}
					}//end s-loop
						if(counter >= 1)
						{
							counter = 0;
							guess.remove(gCurrent);
							solution.remove(sCurrent);
							g = 0;
							s = 0;
							whiteCounter++;
						}
						else {}
				}//end g-loop
			}//end else
		}//end x-loop
	}//end method
}
