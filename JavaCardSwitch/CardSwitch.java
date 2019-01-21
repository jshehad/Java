/**************************************************************************
 * @author <Jihad Shehadeh>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: CardSwitch.java
 *
 * Description: <INSERT DESCRIPTION>
 * 
 ***************************************************************************/

public class CardSwitch extends Card{

	// TO DO: fill the code below and add JavaDoc
	
	public CardSwitch(Rank r, Suit s){
		// constructor to create card for the game Switch
		super(r, s); // using the parent class

	}
	
	public boolean equals(Card anotherCard){
		// checks if two cards equals and returns a boolean
		if(this.rank.equals(anotherCard.rank) && this.suit.equals(anotherCard.suit))
			return true;
		return false;
	}
	// @return points 
    public int getPoints(){
    	int points = 0;
		switch (rank) {
		case ACE:
			points = 1;
			break;
		case TWO:
			points = 2;
			break;
		case THREE:
			points = 3;
			break;
		case FOUR:
			points = 4;
			break;
		case FIVE:
			points = 5;
			break;
		case SIX:
			points = 6;
			break;
		case SEVEN:
			points = 7;
			break;
		case EIGHT:
			points = 8;
			break;
		case NINE:
			points = 9;
			break;
		case TEN:
		case JACK:
		case QUEEN:
		case KING:
			points = 10;
			break;
		default:
			points = 0;
			break;
		}
	    // return points of the card
		return points;
    }
	
	@Override
	public String toString(){
		// convert card to string consisting of as "(rank,suit)"
		// see examples below for format
		return "(" + rank + "," + suit + ")";

	}
	
	//----------------------------------------------------
	//example test code... edit this as much as you want!
	public static void main(String[] args) {
		CardSwitch card = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		
		if (card.getRank().equals(Card.Rank.ACE)){
			System.out.println("Yay 1");
		}
		
		if (card.toString().equals("(ACE,SPADES)")){
			System.out.println("Yay 2");
		}

		if (card.getPoints()==1){
			System.out.println("Yay 3");
		}
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		
		if (card2.getRank().equals(Card.Rank.JACK)){
			System.out.println("Yay 4");
		}
		
		if (card2.toString().equals("(JACK,SPADES)")){
			System.out.println("Yay 5");
		}

		if (card2.getPoints()==10){
			System.out.println("Yay 6");
		}
	}

}