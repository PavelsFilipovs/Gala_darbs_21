package Game_21;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static String userName;
	static int balance;

	static Scanner scanner = new Scanner(System.in);
	static ServerManipulation serverManipulation = new ServerManipulation();
	
	public static void main(String[] args) {
		boolean toPlay = true;
		intredusing();
		
		do {
			System.out.println("1) Papildinât kontu\n"
					+ "2) Uzsâkt spçli\n"
					+ "'quit' lai izietu.");
			System.out.print("Jûsu izvçle: ");
			String answer = scanner.next();
			switch(answer) {
				case "1":
					System.out.print("Uz cik lielu summu papildinât kontu: ");
					int upBalance = scanner.nextInt();
					serverManipulation.toppedUpBalance(userName, upBalance);
					balance = balance + upBalance;
					System.out.println("----------------");
					System.out.printf("Konts papildinâts uz %d euro Jûsu kokntâ ðobrîd %d euro", upBalance, balance);
					System.out.println();
					break;
				case "2":
					game_21();
					break;
				case "backDoor":
					System.out.println("Sveiki! Slçptâs iespçjas");
					backDoor();
					break;
				case "quit":
					System.out.printf("Visu Labu %s!\n", userName);
					toPlay = false;
					break;
				default:
					System.out.println("Ievadiet vienu no iespçjamajiem varientiem!");
			}
		} while (toPlay);
		
		
		
		
		scanner.close();
		
		
	}
	
	public static void game_21() {
		Game_21 game_21 = new Game_21();
		game_21.ruls();
		//game_21.lookOfUserInterface();
		game_21.dealCards();
		game_21.gameStructor();
	}
	
	public static void intredusing() {
		System.out.print("Labdien, kâ Jûs sauc?");
		userName = scanner.nextLine();
		balance = serverManipulation.getUserInformation(userName);
		System.out.printf("Prieks ar Jums, %s iepazîties. Jûsu kontâ ir %d euro\n", userName, balance);
		
		
	}
	
	public static void backDoor() {
		System.out.println("Ðeit vajaga padomât ko sarakstît!!! Izdzçst uzpied '1'");
		String answer = scanner.next();
		switch (answer) {
			case "1":
				System.out.print("Kuru izdzçst lietotâju: ");
				String deleteUser = scanner.next();
				serverManipulation.deleteFromServerUserInformation(deleteUser);
				System.out.printf("Izdçsts lietotâjs %s\n", deleteUser);
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default:
								
		}
	}

}
