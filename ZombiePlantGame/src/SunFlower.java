
public class SunFlower extends Plant{

	private final static int health = 1, damage = 0, price = 2, coolDown = 2;
	private static String name = "SunFlower";
	
	public SunFlower(int rowNumber, int colNumber){
		super(health, damage, rowNumber, colNumber, price, name, coolDown);
	}
	
	
}
