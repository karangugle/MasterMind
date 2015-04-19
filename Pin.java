import java.awt.Color;
//A Pin object  has a Color, an index within a guessed or solution array, a boolean that decides 
//whether this pin is matched or not

public class Pin
{
	private Color color;
	private int index;
	private boolean match;
	String colorName  = "";

	public Pin(Color col, int ind, boolean mat)
	{
		color = col;
		index = ind;
		match = mat;
	}
	public Color getColor()
	{
		return color;
	}
	public int getIndex()
	{
		return index;
	}
	public boolean getMatch()
	{
		return match;
	}
	public String toString()
	{
		if(this.getColor() == Color.RED)
			colorName = "RED";
		else if(this.getColor() == Color.ORANGE)
			colorName = "ORANGE";
		else if(this.getColor() == Color.YELLOW)
			colorName = "YELLOW";
		else if(this.getColor() == Color.GREEN)
			colorName = "GREEN";
		else if(this.getColor() == Color.BLUE)
			colorName = "BLUE";
		else if(this.getColor() == Color.MAGENTA)
			colorName = "MAGENTA";
		return colorName + "  " + index +  "  " + match;
	}

	public boolean colorMatch(Color color, Color other)
	{
		if (color.equals(other))
			return true;
		return false;
	}

}
