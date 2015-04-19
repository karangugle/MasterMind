import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
public class MindRunner
{
	Color [] possibleColors = { Color.RED, Color.ORANGE, Color.YELLOW, 
			Color.GREEN, Color.BLUE, Color.MAGENTA};
	static ArrayList<Pin> solution = new ArrayList<Pin> (4);
	int turnCount = 0;

	public static void main(String [] args)
	{
		MindRunner play = new MindRunner();
		play.decideSolution(solution);
		play.printSolution();
		play.printGameHeader();
		play.processPlayerTurns();
	}
	public void decideSolution(ArrayList<Pin> sol)
	{
		solution = sol;
		for(int x = 0; x < 4; x++)
		{
			int rand = (int) (Math.random() * 6);
			solution.add(new Pin(possibleColors[rand], x, false));
		}
	}
	public void printGameHeader()
	{
		System.out.println("\n\nWelcome to MasterMind!\n\n To play this game, guess 4 colors the computer has come up with"
				+ "\n from the following: Red, Orange, Yellow, Green, Blue, and Magenta."
				+ "\n Once you guess four colors (typed in ALL CAPS, mind you!), my"
				+ "\n artfully designed code will give you a hint as to how many colors"
				+ "\n that you've guessed are correct, and how many are in the right place"
				+ "\n according to the traditional rules with black and white markers."
				+ "\n Make sure to type in all caps!\n\n");
	}
	public void processPlayerTurns()
	{
		Scanner io = new Scanner(System.in);
		while(turnCount <= 10)
		{
			ArrayList<Pin> guess = new ArrayList<Pin> (4);
			
			System.out.print("Please enter Color 1: ");
			String colorOne = io.next();
			guess.add(new Pin (colorCreator(colorOne), 0, false));
			
			System.out.print("Please enter Color 2: ");
			String colorTwo = io.next();
			guess.add(new Pin (colorCreator(colorTwo), 1, false));
			
			System.out.print("Please enter Color 3: ");
			String colorThree = io.next();
			guess.add(new Pin (colorCreator(colorThree), 2, false));
			
			System.out.print("Please enter Color 4: ");
			String colorFour = io.next();
			guess.add(new Pin (colorCreator(colorFour), 3, false));

			Match.hint(guess, solution);
			System.out.println("Black Count is: " + Match.blackCounter + "\nWhite Count is: " + Match.whiteCounter);

			turnCount++;
				if(Match.blackCounter == 4)
				{
					System.out.println("You Win!");
					System.exit(0);
				}
				else if ( turnCount >= 10)
				{
					System.out.println("You Lose :(");
					System.exit(0);
				}
				else{}
		}
	}
	public Color colorCreator(String userColor)
	{
		if(userColor.equals("RED"))
			return Color.RED;
		if(userColor.equals("ORANGE"))
			return Color.ORANGE;
		if(userColor.equals("YELLOW"))
			return Color.YELLOW;
		if(userColor.equals("GREEN"))
			return Color.GREEN;
		if(userColor.equals("BLUE"))
			return Color.BLUE;
		if(userColor.equals("MAGENTA"))
			return Color.MAGENTA;
		else
			return null;


	}
	public void printSolution()
	{
		System.out.print("Solution is:");
		for (int y = 0; y < 4; y++)
		{
			Pin p = null;
			p = solution.get(y);
			System.out.print(" " + p.toString());
		}
	}
}
