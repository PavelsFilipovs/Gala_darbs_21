package Game_21;

import java.util.ArrayList;

public class Dealer implements Player {
	private ArrayList<Card> arrUserCards = new ArrayList<Card>();
	
	@Override
	public void addCardToHands(Card card) {
		arrUserCards.add(card);
	}
	
	public boolean testIfHave_Above15() {
		boolean above15 = false;
		int sum = 0;
		for (int i = 0; i < arrUserCards.size(); i++) {
			int[] value = arrUserCards.get(i).getValue();
			sum = value[0] + sum;
		}
		if (sum > 21) {
			sum = 0;
			for (int i = 0; i < arrUserCards.size(); i++) {
				int[] value = arrUserCards.get(i).getValue();
				sum = value[1] + sum;
			}
		}
		
		if (sum < 16) {
			above15 = true;
		}
		return above15;
	}
	
	@Override
	public void showCards() {
		int sum;
		String cardName = arrUserCards.get(0).getCardType();
		int[] value = arrUserCards.get(0).getValue();

		System.out.println("Dal�t�ja k�rtis:");
		if (value[0] == 11) {
			System.out.println("* " + cardName + " ar v�rt�bu " + value[0] + " vai ar� " + value[1]);
		} else {
			System.out.println("* " + cardName + " ar v�rt�bu " + value[0]);
		}
		System.out.println("* Un viena nosl�pta");
		sum = value[0];
		System.out.println("�obr�d dal�t�ja kopsuma ir " + sum);
		System.out.println();
	
	}
	
	public void showAllCards() {
		int sum = 0;
		System.out.println("Dal�t�ja k�rtis: ");
		for (int i = 0; i < arrUserCards.size(); i++) {
			String cardName = arrUserCards.get(i).getCardType();
			int[] value = arrUserCards.get(i).getValue();
			
			if (value[0] == 11) {
				System.out.println("* " + cardName + " ar v�rt�bu " + value[0] + " vai ar� " + value[1]);
			} else {
				System.out.println("* " + cardName + " ar v�rt�bu " + value[0]);
			}
			
			sum = value[0] + sum;
		}
		if (sum > 21) {
			sum = 0;
			for (int i = 0; i < arrUserCards.size(); i++) {
				int[] value = arrUserCards.get(i).getValue();
				sum = value[1] + sum;
			}
		}
		System.out.println("�obr�d dal�t�ja kopsuma ir " + sum);
		System.out.println();
	}
	
	@Override
	public int Sum() {
		int sum = 0;
		for (int i = 0; i < arrUserCards.size(); i++) {
			int[] value = arrUserCards.get(i).getValue();
			sum = value[0] + sum;
		}
		if (sum > 21) {
			sum = 0;
			for (int i = 0; i < arrUserCards.size(); i++) {
				int[] value = arrUserCards.get(i).getValue();
				sum = value[1] + sum;
			}
		}
		return sum;
	}
	
}
