
package Model;

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
		if(this.getHealth() <= 0){
			this.isDead = true;
		}
	}
	
	
	// need to implement
	public double getPosition(int step){
		return 0;
	}

	public void setSpeed(double newSpeed){
		this.speed = newSpeed;
	}

	public double getSpeed(){
		return speed;
	}
}
