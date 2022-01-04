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
			System.out.println("1) Papildin�t kontu\n"
					+ "2) Uzs�kt sp�li\n"
					+ "'quit' lai izietu.");
			System.out.print("J�su izv�le: ");
			String answer = scanner.next();
			switch(answer) {
				case "1":
					System.out.print("Uz cik lielu summu papildin�t kontu: ");
					int upBalance = scanner.nextInt();
					serverManipulation.toppedUpBalance(userName, upBalance);
					balance = balance + upBalance;
					System.out.println("----------------");
					System.out.printf("Konts papildin�ts uz %d euro J�su koknt� �obr�d %d euro", upBalance, balance);
					System.out.println();
					break;
				case "2":
					game_21();
					break;
				case "backDoor":
					System.out.println("Sveiki! Sl�pt�s iesp�jas");
					backDoor();
					break;
				case "quit":
					System.out.printf("Visu Labu %s!\n", userName);
					toPlay = false;
					break;
				default:
					System.out.println("Ievadiet vienu no iesp�jamajiem varientiem!");
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
		System.out.print("Labdien, k� J�s sauc?");
		userName = scanner.nextLine();
		balance = serverManipulation.getUserInformation(userName);
		System.out.printf("Prieks ar Jums, %s iepaz�ties. J�su kont� ir %d euro\n", userName, balance);
		
		
	}
	
	public static void backDoor() {
		System.out.println("�eit vajaga padom�t ko sarakst�t!!! Izdz�st uzpied '1'");
		String answer = scanner.next();
		switch (answer) {
			case "1":
				System.out.print("Kuru izdz�st lietot�ju: ");
				String deleteUser = scanner.next();
				serverManipulation.deleteFromServerUserInformation(deleteUser);
				System.out.printf("Izd�sts lietot�js %s\n", deleteUser);
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default:
								
		}
	}

}
