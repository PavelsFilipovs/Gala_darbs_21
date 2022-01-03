package Game_21;

import java.util.Scanner;

public class Game_21 {
	Dealer dealer = new Dealer();
	User user = new User();
	CardsDeck cardsDeck = new CardsDeck();
	
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
					System.out.println("Uzvarçja dalîtais");
					playGame = false;
					question = 3;
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
					question = 3;
				}
			}
			
		}
	}
	
	public void winnerIs() {
		int userSum, dealerSum;
		
		userSum = user.userSum();
		dealerSum = dealer.dealerSum();
		
		if (userSum == dealerSum) {
			System.out.println("Uzvarçja abi un atdot atpakaï viòu naudu");
		} else if (userSum > dealerSum){
			System.out.println("Uzvarçja spçlçtâjs");
		} else if (dealerSum > 21) {
			System.out.println("Uzvarçja spçlçtâjs");
		} else {
			System.out.println("Uzvarçja dalîtais");
		}
	}
	
}
