package Game_21;

import java.util.Scanner;

public class Game_21 {
	Dealer dealer = new Dealer();
	User user = new User();
	CardsDeck cardsDeck = new CardsDeck();
	
	public void ruls() {
		System.out.println("S�koties sp�lei, dal�t�js izdala katram sp�l�t�jam,"
				+ " tai skait� ar� sev, divas k�rtis, turkl�t 1 dal�t�ja k�rts tiek apgriezta redzama. "
				+ "\nKatrai k�rtij atbilst noteikta punktu v�rt�ba:\r\n"
				+ "  *kalpam, d�mai un karalim � 10 punkti;\r\n"
				+ "  *d�zim � 11 vai 1 punkts, atkar�b� no t�, k� ir izdev�g�k sp�l�t�jam;\r\n"
				+ "  *p�r�j�m k�rt�m t�da v�rt�ba, kas uz t�s nor�d�ta.\r\n"
				+ "Sp�l�t�js var piepras�t papildus k�rti no kavas."
				+ " P�c papildus k�rts sa�em�anas, pa�reiz�jai summai tiek pieskait�ta sa�emt�s k�rts v�rt�ba."
				+ "\nJa t� p�rsniedz 21, tad sp�l�t�js zaud� un izst�jas no ��s partijas. \nJa 21 nav sasniegts,"
				+ " sp�l�t�js dr�kst piepras�t v�l vienu k�rti, vai ar� palikt uz vietas."
				+ "\nP�d�jais sp�l�t�js apl� ir dal�t�js, kur� atkl�j savu otru k�rti, un nov�rt� kopsummu.\r\n"
				+ "Tas, k� dal�t�jam ir j�sp�l�, ir stingri noteikts: tam ir j��em n�kam� k�rts,"
				+ " ja vi�a k�r�u kopsumma nep�rsniedz 16, un j�paliek, ja t� ir vismaz 17 un liel�ka."
				+ "\nDal�t�js ar� var p�rsniegt divdesmit viena punkta summu, ta�u tas neattiecas uz sp�l�t�jiem,"
				+ " kuri pirms tam ir zaud�ju�i pa�i p�rsniedzot 21.");
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
					System.out.println("Uzvar�ja dal�tais");
					playGame = false;
					question = 3;
				}
			} 
			while (question == 2) {
				dealer.showAllCards();
				user.showCards();
				if (dealer.testIfHave_Above15()) {
					dealer.addCardToHands(cardsDeck.getCardFromDeck());
					System.out.println("Dal�t�js pa�em velvienu k�rti");
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
			System.out.println("Uzvar�ja abi un atdot atpaka� vi�u naudu");
		} else if (userSum > dealerSum){
			System.out.println("Uzvar�ja sp�l�t�js");
		} else if (dealerSum > 21) {
			System.out.println("Uzvar�ja sp�l�t�js");
		} else {
			System.out.println("Uzvar�ja dal�tais");
		}
	}
	
}
