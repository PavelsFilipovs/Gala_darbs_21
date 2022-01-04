package Game_21;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Player {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Card> arrUserCards = new ArrayList<Card>();
	private String name;
	
	@Override
	public void addCardToHands(Card card) {
		arrUserCards.add(card);
	}
	
	public int askQuestion() {
		int answer;
		System.out.println("1) Piepras�t k�rti");
		System.out.println("2) Palikt uz vietas");
		System.out.print("J�su izv�le: ");
		answer = scanner.nextInt();
		System.out.println("-----------------------------------");
		
		return answer;
	}
	
	@Override
	public void showCards() {
		int sum = 0;
		System.out.println("J�su k�rtis: ");
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
		System.out.println("�obr�d sp�l�t�ja kopsuma ir " + sum);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
