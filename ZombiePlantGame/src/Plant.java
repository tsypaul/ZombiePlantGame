
public abstract class Plant {
	private int health;
	private int damage, rowNumber, colNumber, price, coolDown;
	private String name;
		
	public Plant(int health, int damage, int rowNumber, int colNumber,
			int price, String name, int coolDown){
		this.health = health;
		this.damage = damage;
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.price = price;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCoolDown(){
		return this.coolDown;
	}
	
	public void setHealth(int newHealth){
		this.health = newHealth;
	}
	
	public boolean isDead(){
		return health <= 0 ? true : false;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public int getRowNumber(){
		return this.rowNumber;
	}
	
	public int getColNumber(){
		return this.colNumber;
	}
}
