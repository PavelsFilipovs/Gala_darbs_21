package Game_21;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Card> arrUserCards = new ArrayList<Card>();
	
	public void addCardToHands(Card card) {
		arrUserCards.add(card);
	}
	
	public int askQuestion() {
		int answer;
		System.out.println("1) Pieprasît kârti");
		System.out.println("2) Palikt uz vietas");
		System.out.print("Jûsu izvçle: ");
		answer = scanner.nextInt();
		System.out.println("-----------------------------------");
		
		return answer;
	}
	
	public void showCards() {
		int sum = 0;
		System.out.println("Jûsu kârtis: ");
		for (int i = 0; i < arrUserCards.size(); i++) {
			String cardName = arrUserCards.get(i).getCardType();
			int[] value = arrUserCards.get(i).getValue();
			
			if (value[0] == 11) {
				System.out.println("* " + cardName + " ar vçrtîbu " + value[0] + " vai arî " + value[1]);
			} else {
				System.out.println("* " + cardName + " ar vçrtîbu " + value[0]);
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
		System.out.println("Ðobrîd spçlçtâja kopsuma ir " + sum);
		System.out.println();
		
	}
	
	public int userSum() {
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
