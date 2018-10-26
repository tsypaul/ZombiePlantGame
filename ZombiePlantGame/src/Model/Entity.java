package Model;

//Class for all the criteria for the game

public abstract class Entity {

	private int health;
	private int damage;
	private int count;
	private String name;

	public Entity(){
		health = 0;
		damage = 0;
		count = 0;
		name = null;
	}

	public Entity(int health, int damage, int count,String name){
		this.health = health;
		this.damage = damage;
		this.count = count;
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}