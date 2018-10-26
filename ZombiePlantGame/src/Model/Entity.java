
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

	public Entity(int health, int damage, int count, int String name){
		this.health = health;
		this.damage = damage;
		this.count = count;
		this.name = name;
	}

	


}