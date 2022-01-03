package Game_21;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ServerManipulation serverManipulation = new ServerManipulation();
		
		String userName;
		int balance;
		
		System.out.print("Labdien, kâ Jûs sauc?");
		userName = scanner.nextLine();
		balance = serverManipulation.getUserInformation(userName);
		System.out.printf("Prieks ar Jums, %s iepazîties. Jûsu kontâ ir %d", userName, balance);
		
		
		String answer = scanner.nextLine();
		switch(answer) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default:
				System.out.println("Ivadiet Vienu no iespçjamajiem varientiem!");
		}
		
		
		boolean oneMoreGameToPlay = true;
		while (oneMoreGameToPlay) {	
			Game_21 game_21 = new Game_21();
			game_21.ruls();
			//game_21.lookOfUserInterface();
			game_21.dealCards();
			game_21.gameStructor();
			
			System.out.println("Uzpçlçt vel vienu, uzpiediet 'yes'.");
		}
		
		scanner.close();
		
		
	}
	
	public void game_21() {
		Game_21 game_21 = new Game_21();
		game_21.ruls();
		//game_21.lookOfUserInterface();
		game_21.dealCards();
		game_21.gameStructor();
	}

}
