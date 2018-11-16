package gui;

import java.awt.Image;

public class ZombieObject {
	
	private Image z;
	private int x = 810, y, speed;
	private int checkX, health;

	public ZombieObject(Image z, int y, int speed){
		this.z = z;
		this.y = y;
		this.speed = speed;
		this.checkX = 765;
		this.health = 150;
	}

	public Image getZ() {
		return z;
	}

	public void setZ(Image z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void updateHealth(int health){
		this.health -= health;
		if(this.health > 0){
			System.out.println(""+this.health);
		}
	}
	
	
	public void checkStatus(){
		// check if a block has plant
		if(this.x < this.checkX){
			this.x = this.checkX;
			this.checkX -= 90;
		}
		// check if a plant is dead, if dead, remove it.
		if(this.health < 0){
			this.z = null;
		}
	}
}
