package Model;

public class Plant {
	private int health, coolDown;
	private boolean isDead, isCooledDown;
	private final int damage, rowNumber, colNumber, price;
		
	public Plant(int health, int damage, int rowNumber, int colNumber,
			int price, int coolDown){
		this.health = health;
		this.damage = damage;
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.price = price;
		this.coolDown = coolDown;
		this.isDead = false;
	}
	
	public void updateCoolDown(){
		 if(!this.isCooledDown){
			 
		 }
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getPrice(){
		return this.price;
	}
}
