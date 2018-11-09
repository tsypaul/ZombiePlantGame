
public class WallNut extends Plant{

	private final static int health = 4, damage = 0, price = 2, coolDown = 3;
	private static String name = "WallNut";
	
	public WallNut(int rowNumber, int colNumber){
		super(health, damage, rowNumber, colNumber, price, name, coolDown);
	}
	
}
