
public class DnDMath
{
    public static int getModifierValue(int statValue){
	int temp;
	
	temp = (statValue - 10) / 2;
	
	return temp;
    }
}
