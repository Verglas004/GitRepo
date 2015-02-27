
public class Dice
{
    private int value;
    private int sides;
    
    public Dice(int sides){
	this.sides = sides;
    }
    
    public void roll(){
	value = (int) ( Math.random() * sides ) + 1;
    }
    
    public int getValue(){
	return value;
    }
    
    public String toString(){
	return value + "";
    }
}
