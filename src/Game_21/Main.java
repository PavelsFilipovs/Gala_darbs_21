package Game_21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String yes = "yes";
		boolean oneMoreGameToPlay = true;
		while (oneMoreGameToPlay) {	
		Game_21 game_21 = new Game_21();
		game_21.ruls();
		//game_21.lookOfUserInterface();
		game_21.dealCards();
		game_21.gameStructor();
		
		System.out.println("Uzpçlçt vel vienu uzpiediet 'yes'!");
		if (scanner.nextLine().equals(yes)) {
			oneMoreGameToPlay = true;
		} else {
			oneMoreGameToPlay = false;
		}
		}
	}

}
