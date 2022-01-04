package Game_21;

import java.util.Scanner;

public class Game_21 {
	Dealer dealer = new Dealer();
	User user = new User();
	CardsDeck cardsDeck = new CardsDeck();
	ServerManipulation serverManipulation = new ServerManipulation();
	
	private int bet;
	private static String userName;
	
	public void ruls() {
		System.out.println("Sâkoties spçlei, dalîtâjs izdala katram spçlçtâjam,"
				+ " tai skaitâ arî sev, divas kârtis, turklât 1 dalîtâja kârts tiek apgriezta redzama. "
				+ "\nKatrai kârtij atbilst noteikta punktu vçrtîba:\r\n"
				+ "  *kalpam, dâmai un karalim — 10 punkti;\r\n"
				+ "  *dûzim — 11 vai 1 punkts, atkarîbâ no tâ, kâ ir izdevîgâk spçlçtâjam;\r\n"
				+ "  *pârçjâm kârtîm tâda vçrtîba, kas uz tâs norâdîta.\r\n"
				+ "Spçlçtâjs var pieprasît papildus kârti no kavas."
				+ " Pçc papildus kârts saòemðanas, paðreizçjai summai tiek pieskaitîta saòemtâs kârts vçrtîba."
				+ "\nJa tâ pârsniedz 21, tad spçlçtâjs zaudç un izstâjas no ðîs partijas. \nJa 21 nav sasniegts,"
				+ " spçlçtâjs drîkst pieprasît vçl vienu kârti, vai arî palikt uz vietas."
				+ "\nPçdçjais spçlçtâjs aplî ir dalîtâjs, kurð atklâj savu otru kârti, un novçrtç kopsummu.\r\n"
				+ "Tas, kâ dalîtâjam ir jâspçlç, ir stingri noteikts: tam ir jâòem nâkamâ kârts,"
				+ " ja viòa kârðu kopsumma nepârsniedz 16, un jâpaliek, ja tâ ir vismaz 17 un lielâka."
				+ "\nDalîtâjs arî var pârsniegt divdesmit viena punkta summu, taèu tas neattiecas uz spçlçtâjiem,"
				+ " kuri pirms tam ir zaudçjuði paði pârsniedzot 21.");
		System.out.println();
		cardsDeck.makeCardDeck();
	}
	
	
	public void dealCards() {
		for (int i = 0; i < 2; i++) {
			dealer.addCardToHands(cardsDeck.getCardFromDeck());
			user.addCardToHands(cardsDeck.getCardFromDeck());
		}
	}
	
	public void gameStructor() {
		
		
		makeBet();
		dealer.showCards();
		user.showCards();
		boolean playGame = true;
		while (playGame) {
			int question = user.askQuestion();
			if (question == 1) {
				dealer.showCards();
				user.addCardToHands(cardsDeck.getCardFromDeck());
				user.showCards();
				if (user.userSum() > 21) {
					winnerIs();
					playGame = false;
				}
			} 
			while (question == 2) {
				dealer.showAllCards();
				user.showCards();
				if (dealer.testIfHave_Above15()) {
					dealer.addCardToHands(cardsDeck.getCardFromDeck());
					System.out.println("Dalîtâjs paòem velvienu kârti");
					System.out.println("-------------------------------");
				} else {
					winnerIs();
					playGame = false;
					break;
				}
			}
			
		}
	
	}
	
	
	public void getName() {
		Main main = new Main();
		userName = main.userName;
	}
	
	public void winnerIs() {
		int userSum, dealerSum;
		userSum = user.userSum();
		dealerSum = dealer.dealerSum();
		
		if (userSum == dealerSum) {
			System.out.printf("Uzvarçja abi un atdot atpakaï naudu %d euro", bet);
			serverManipulation.toppedUpBalance(user.getName(), bet);
		} else if (userSum == 21){
			bet = bet * 3;
			System.out.printf("Uzvarçja spçlçtâjs un viòa vinests ir %d euro", bet);
			serverManipulation.toppedUpBalance(user.getName(), bet);
		} else if (userSum > dealerSum){
			bet = bet * 2;
			serverManipulation.toppedUpBalance(user.getName(), bet);
			System.out.printf("Uzvarçja spçlçtâjs un viòa vinests ir %d euro", bet);
		} else if (dealerSum > 21) {
			bet = bet * 2;
			serverManipulation.toppedUpBalance(user.getName(), bet);
			System.out.printf("Uzvarçja spçlçtâjs un viòa vinests ir %d euro", bet);
		} else {
			System.out.println("Uzvarçja dalîtais un spçlçtâjs zaudçja uzlikto likmi");
		}
	}
	
	public void makeBet() {
		getName();
		user.setName(userName);
		String userName = user.getName();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Cik lielu summu liksiet uz spçli...");
		bet = scanner.nextInt();
		serverManipulation.toppedDownBalance(userName, bet);
	}
	
}
