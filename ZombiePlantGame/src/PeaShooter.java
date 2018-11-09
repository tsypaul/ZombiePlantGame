
public class PeaShooter extends Plant{
	
	private final static int health = 2, damage = 1, price = 3, coolDown = 3;
	private static String name = "PeaShooter";
	
	public PeaShooter(int rowNumber, int colNumber){
		super(health, damage, rowNumber, colNumber, price, name, coolDown);
	}
	
}
