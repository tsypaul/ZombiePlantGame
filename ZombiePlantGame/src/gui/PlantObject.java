package gui;

public class PlantObject {
	
	private int health, x, y;
	private String name;

	public PlantObject(String name, int x, int y){
		if(name.equals("Sunflower")){
			this.health = 50;
		}
		if(name.equals("Peashooter")){
			this.health = 50;
		}
		if(name.equals("Wallnut")){
			this.health = 100;
		}
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public boolean checkDead(){
		return this.health < 0;
	}
	
	public void damage(){
		this.health -= 50;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
