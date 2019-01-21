
/**************************************************************************
 * @author Yutao Zhong and Jitin Krishnan
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Card.java
 *
 * Description: Abstract Card class from which a card class specific to
 * any game can be constructed. This file SHOULD NOT be modified.
 * 
 ***************************************************************************/

public abstract class Card {
	
	enum Rank{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}

	enum Suit{
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}
	
	protected Rank rank;
	protected Suit suit;
	
	public Card(Rank r, Suit s){
		rank = r;
		suit = s;
		/**
		 * @param r Rank of card
		 * @param s Suit of card */
	}

	public Rank getRank(){
		/**@return rank */
		// O(1)
		return rank;
	}
	
	public Suit getSuit(){
		/**@return suit */
		// O(1)
		return suit;
	}
	
	public abstract boolean equals(Card c);
    
    abstract int getPoints();
		
	@Override
	public abstract String toString();

}
