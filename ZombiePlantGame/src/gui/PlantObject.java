package gui;

public class PlantObject {
	
	private int health;
	private String name;

	public PlantObject(String name){
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
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean checkDead(){
		return this.health < 0;
	}
	
	public void damage(){
		this.health -= 25;
	}
	
	
}
