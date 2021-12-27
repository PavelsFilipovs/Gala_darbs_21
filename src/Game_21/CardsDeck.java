package Game_21;

import java.util.ArrayList;
import java.util.Random;


public class CardsDeck {
	Random random = new Random();
	private static ArrayList<Card> deckArr = new ArrayList<Card>();
	private String[] suits = {"Ercena", "Kârava", "Pîía", "Kreièa"};
	private String[] cardType = {"Dûzis", "Kungs", "Dâma", "Kalps", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
	
	
	
	public void makeCardDeck() {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < cardType.length; j++) {
				Card card = new Card();
				int[] value;
				card.setCardType(suits[i] + "_" + cardType[j]);
				if (j == 0) {
					value = new int[2];
					value[0] = 11;
					value[1] = 1;
					card.setValue(value);
				} else {
					value = new int[2];
					if (1 == j || 2 == j || 3 == j) {
						value[0] = 10;
						value[1] = 10;
					} else {
						value[0] = Integer.parseInt(cardType[j]);
						value[1] = Integer.parseInt(cardType[j]);
					}
					card.setValue(value);
				}
				deckArr.add(card);	
			}
		}
	}
	
	public Card getCardFromDeck() {
		int randomCardGet = random.nextInt(deckArr.size());
		Card card = deckArr.get(randomCardGet);
		deckArr.remove(randomCardGet);
		return card;
		
	}
}
