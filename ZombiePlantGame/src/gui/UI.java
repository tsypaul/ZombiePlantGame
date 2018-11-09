package gui;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI {
	
//	public static void printGame(Garden g){
//		for(int i = 0; i < g.getX(); i++){
//			for(int j = 0; j < g.getY(); j++){
//				if(g.getPlantList()[i][j] != null){
//					System.out.println(g.getPlantList()[i][j].getName()+" at "+i+","+j);
//				}
//			}
//		}
//	}
//	
//	public static void main(String[] args){
//		Scanner s = new Scanner(System.in);
//		Pattern startGame = Pattern.compile("exit|\\d+,\\d+");
//		String str;
//		while(true){
//			System.out.println("To start a game, please enter the size x,y of the board (normally 9*5, format: 9,5) or exit to quit:");
//			str = s.nextLine();
//			Matcher matcher = startGame.matcher(str);
//			if(matcher.find()){
//				if(str.equals("exit")){
//					System.exit(0);
//				}
//				break;
//			}
//		}
//		int x = Integer.parseInt(str.split(",")[0]);
//		int y = Integer.parseInt(str.split(",")[1]);
//		System.out.println(x +" " +y);
//		
//		System.out.println("You are going to be given 20 suns at the beginning of the game.");
//		
//		Garden g = new Garden(x, y, 20);
//		System.out.println(g.getSun() + "");
//		while(g.checkGameOver()){
//			System.out.println("This is round " + g.getRound());
//			System.out.println("Please select the command:");
//			System.out.println("1. Plant a plant with x,y coordinate");
//			System.out.println("2. Dig a plant with x,y coordinate");
//			System.out.println("3. Collect suns");
//			System.out.println("4. Go forward next n rounds");
//			System.out.println("5. Exit");
//			str = s.nextLine();
//			Pattern spot = Pattern.compile("1\\s+(\\d+),(\\d+)");
//			Pattern digSpot = Pattern.compile("2\\s+(\\d+),(\\d+)");
//			Pattern goForward = Pattern.compile("4\\s+(\\d+)");
//			Matcher matcher = spot.matcher(str);
//			Matcher matcher2 = digSpot.matcher(str);
//			Matcher matcher3 = goForward.matcher(str);
//			if(matcher.find()){
//				x = Integer.parseInt(matcher.group(1));
//				y = Integer.parseInt(matcher.group(2));
//				System.out.println("Please select a type of plant:");
//				System.out.println("1. Sunflower");
//				System.out.println("2. Peashooter");
//				System.out.println("3. Wallnut");
//				System.out.println("4. Go back to main manu");
//				System.out.println("5. Exit");
//				str = s.nextLine();
//				if(str.equals("1")){
//					SunFlower sf = new SunFlower(x, y);
//					try{
//						g.addPlant(sf, x, y);
//					}catch(Exception e){
//						continue;
//					}
//					printGame(g);
//				}
//				if(str.equals("2")){
//					PeaShooter ps = new PeaShooter(x, y);
//					try{
//						g.addPlant(ps, x, y);
//					}catch(Exception e){
//						continue;
//					}
//					printGame(g);
//				}
//			}
//			if(matcher2.find()){
//				// dig plant at (x,y)
//				x = Integer.parseInt(matcher2.group(1));
//				y = Integer.parseInt(matcher2.group(2));
//				g.removePlant(x, y);
//				continue;
//			}
//			if(matcher3.find()){
//				// go forward x rounds
//				x = Integer.parseInt(matcher3.group(1));
//				g.processGame(x);
//				g.setRound(g.getRound() + x);
//			}
//			if(str.equals("3")){
//				//collect suns
//			}
//		}
//	}
}
