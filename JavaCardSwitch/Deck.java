/**************************************************************************
 * @author Yutao Zhong and Jitin Krishnan
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Deck.java
 *
 * Description: Class representing a deck of cards with basic functionalities
 * of shuffling, adding, dealing, etc.
 *
 * TASK: Comment using JavaDoc and show the Big-O runtime of each method.
 * Code on this file should NOT be modified.
 * 
 ***************************************************************************/

public class Deck<T extends Card> {
	
	private Hand<T> setOfCards;
	
	public Deck(){
		/**
		 * Creates set of cards using the hand constructor */
		setOfCards = new Hand<T>();
	}
	
	public boolean addCard(T c){
		/**
		 * @param c object card
		 * adds card to hand
		 * @return boolean if it was successful */
		// O(1)
		if (hasCard(c))
			return false;
		setOfCards.addCard(c);
		return true;
	}
	
	public boolean hasCard(T c){
		/**
		 * @param c object card
		 * return boolean if next card is found*/
		// O(N)
		return (setOfCards.indexOf(c)!=-1);
	
	}

	public void shuffle() {
		/** Shuffles cards*/
		// O(N)
		for ( int i = setOfCards.numCards()-1; i >= 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
	        T temp = setOfCards.getCard(i);
            	setOfCards.setCard(i, setOfCards.getCard(rand));
            	setOfCards.setCard(rand, temp);
	    }
	}
	
	public T dealNextCard() {
		/** */
		// O(N)
		if(setOfCards.numCards()==0) return null;
		T temp = this.setOfCards.removeCard(setOfCards.numCards()-1);
		return temp;
	}

	public boolean isEmpty() {
		/**@return boolean if setofcards is empty  */
		// O(1)
		return this.setOfCards.numCards() == 0;
	}

	public int cardCount(){
		/**@return number of cards */
		// O(1)
		return this.setOfCards.numCards();
	}
	
	public String toString(){
		// O(1)
		StringBuilder sb = new StringBuilder("Deck ");
    		int numCards = cardCount();
    		if (numCards ==0){
    			sb.append("currently with no cards.");
    		}
    		else{
    			sb.append("with "+numCards+ " cards:\n");
    			sb.append(setOfCards.toString());
    		}
    		return sb.toString();
  	}

}
