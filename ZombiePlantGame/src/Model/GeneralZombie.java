
public abstract class GeneralZombie extends Entity {
	
	private double speed;
	private boolean isDead, isStopped;

	public GeneralZombie(){
		super();
		this.speed = 15;
	}
	
	public GeneralZombie(int health, int damage, int count, double speed, String name){
		super(health,damage,count,name);
		this.speed = speed;
		this.isDead = false;
		this.isStopped = false;
	}
	
	public void stop(){
		this.isStopped = true;
	}
	
	public void dead(){
		if(this.health <= 0){
			this.isDead = true;
		}
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	// need to implement
	public double getPosition(int step){
		return 0;
	}

	public int setSpeed(int newSpeed){
		this.speed = newSpeed;
	}

	public int getSpeed(){
		return speed;
	}
}
