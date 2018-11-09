
public class Zombie {
	private int health;
	private final int damage, rowNumber;
	private double speed;
	private boolean isStopped;
	
	public Zombie(int health, int damage, int rowNumber, double speed){
		this.health = health;
		this.damage = damage;
		this.rowNumber = rowNumber;
		this.speed = speed;
		this.isStopped = false;
	}
	
	public void stop(){
		this.isStopped = true;
	}
	
	public boolean isdead(){
		return this.health <= 0 ? true : false;
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getRowNumber(){
		return this.rowNumber;
	}
	
	// need to implement
	public double getPosition(int step){
		return 0;
	}
}
