import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Garden {
	private final int boardX, boardY;
	private int sun;
	private int round = 0;
	private Plant[][] plantList;
	private HashMap<Integer, PriorityQueue<Zombie>> zombieList;
	private Map<Class<? extends Plant>, Integer> coolDownList;
	
	public Garden(int boardX, int boardY, int sun){
		this.boardX = boardX;
		this.boardY = boardY;
		this.sun = sun;	
		this.plantList = new Plant[boardX][boardY];
		this.zombieList = new HashMap<Integer, PriorityQueue<Zombie>>();
	}
	
	public int getY(){
		return this.boardY;
	}
	
	public int getX(){
		return this.boardX;
	}
	
	public void setSun(int sun){
		this.sun = sun;
	}
	
	public int getSun(){
		return this.sun;
	}
	
	public int getRound(){
		return this.round;
	}
	
	public void setRound(int round){
		this.round = round;
	}
	
	public Plant[][] getPlantList(){
		return this.plantList;
	}
	
	// add a zombie to the board
	public void addZombie(Zombie z){
		if(!this.zombieList.containsKey(z.getRowNumber())){
			this.zombieList.put(z.getRowNumber(), new PriorityQueue<Zombie>());
		}else{
			this.zombieList.get(z.getRowNumber()).add(z);
		}
	}
	
	public boolean checkCD(Plant p){
		// check if the cdList contains SunFlower, Peashooter or WallNut type
		// if not, put it in a list with value of its coolDown
		if(!coolDownList.containsKey(p.getClass())){
			coolDownList.put(p.getClass(), p.getCoolDown());
			return true;
		}else{
			// if yes, check if the plant is on coolDown
			if(coolDownList.get(p.getClass()) == p.getCoolDown()){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public void updateCD(){
		Iterator it = coolDownList.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Class<? extends Plant>, Integer> pair = (Map.Entry<Class<? extends Plant>, Integer>) it.next();
			coolDownList.put(pair.getKey(), pair.getValue() + 1);
		}
	}
	
	// add a plant to the board
	public void addPlant(Plant p, int x, int y) throws InCoolDownException, PositionOccupiedException, CannotAffordException{
		// check cool down
		if(!checkCD(p)){
			System.out.println("Sorry, the plant you selected is on cool down.");
			throw new InCoolDownException("this plant is in cd");
		}
		// check if this position is occupied
		if(this.plantList[x][y] != null){
			System.out.println("Sorry, the position you selected is occupied.");
			throw new PositionOccupiedException("this position is occupied");
		}
		this.sun -= p.getPrice();
		// check if the plant is affordable
		if(this.sun < 0){
			System.out.println("Sorry, you cannot afford this plant.");
			this.sun += p.getPrice();
			throw new CannotAffordException("you don't have enough suns");
		}
		// add the plant to the list
		this.plantList[x][y] = p;
	}
	
	public void removePlant(int x, int y){
		this.plantList[x][y] = null;
	}
	
	public void processGame(int rounds){
		
	}
	
	public boolean checkGameOver(){
		return true;
	}
	
}
