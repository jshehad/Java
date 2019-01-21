/**************************************************************************
 * @author <Jihad Shehadeh> 
 * CS310 Spring 2018 
 * Project 1 
 * George Mason University
 * 
 * File Name: Hand.java
 *
 * Description: <INSERT DESCRIPTION>
 * 
 ***************************************************************************/

public class Hand<T extends Card> {

	// TO DO: add your implementation and JavaDoc

	private T[] cards;
	private int numCards;

	@SuppressWarnings("unchecked")
	public Hand() {
		// constructor
		// initial size of cards must be no greater than 5
		/**
		 * Constructor does not accept parameters
		 * It creates an array list of a size 5 */
		this.cards = (T[]) new CardSwitch[5];
		this.numCards = 0;
	}

	public int numCards() {
		// return the number of cards
		// O(1)
		/**
		 * @return numCards number of cards in hand */
		return numCards;
	}

	public T getCard(int index) {
		// return card at index
		// throw RuntimeException for invalid index
		// O(1)
		// check whether i is a valid index
		// return item if valid
		// otherwise?
		/**
		 * @param index, accept an integer of an index
		 * @throw a Runtime, if index is not in range
		 * @return card at index */
		if ((index >= 0) && (index < numCards)) {
			return cards[index];
		} else {
			throw new RuntimeException();
		}
	}

	public void setCard(int index, T c) {
		// change the card at index to be c
		// throw RuntimeException for invalid index
		// O(1)
		/**
		 * @param index accept integer
		 * @param c accept object card
		 * @throw Runtime if index is out of range */
		if ((index >= 0) && (index < numCards)) {
			cards[index] = c;
		} else {
			throw new RuntimeException();
		}
	}

	public void addCard(T c) {
		// add card c at the end
		// O(N)
		// check whether capacity has reached
		/**
		 * @param c accept object cards */
		if (numCards == cards.length) { // if equal
			// expand array
			@SuppressWarnings("unchecked")
			T[] cards2 = (T[]) new CardSwitch[cards.length * 2]; // create a new array, double the size
			// copy over from old array
			
			for (int i = 0; i < cards.length; i++) {
				cards2[i] = cards[i];
			}
			// overwrite old data
			cards = cards2;
		}
		// now we can add + update size
		cards[numCards] = c;
		numCards++;
	}

	public int indexOf(T c) {
		// find the index of a given card c,
		// returns -1 if not found
		// O(N)
		/**@param c is an object card
		 * @return index at card location */
		for (int i = 0; i < numCards; i++) {
			if (c.equals(cards[i])) {
				return i;
			}
		}
		// If we get here, c is not in the list
		return -1;
	}

	public T removeCard(int index) {
		// remove the card at index,
		// throw RuntimeException for invalid index
		// O(N)
		// check index
		if ((index >= 0) && (index < numCards)) {
			// valid index, grab the item
			/**@param index accept integer
			 * @throw Runtime if integer is out of range
			 * @return tmp removed card */
			T tmp = cards[index];

			// shift cards to the left
			for (int i = index; i < numCards; i++) {
				cards[i] = cards[i + 1];
			}
			numCards--;
			return tmp;
		} else {
			throw new RuntimeException();
		}
	}

	public boolean removeCard(T c) {
		// remove card c,
		// returns false if no such card
		// O(N)
		// easy with indexOf and remove
		/**
		 * @param c object card
		 * @return boolean if the card is removed */
		int i = indexOf(c);
		if(i != -1 && removeCard(i) != null) {
			return true;
		}
		return false;
	}

	// --------------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need a working CardSwitch class to run the given code

	// Not required, update for your testing purpose
	@Override
	public String toString() {
		// return string representation of hand
		// update if you want to include information for all cards in hand
		return "Hand with " + numCards + " cards";
		//return Arrays.toString(cards);

	}

	public static void main(String[] args) {

		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);

		Hand<CardSwitch> myHand = new Hand<CardSwitch>();
		myHand.addCard(card1);
		myHand.addCard(card2);
		
		//System.out.println(myHand);

		if ((myHand.numCards() == 2) && (myHand.getCard(0).equals(card1))) {
			System.out.println("Yay 1");
		}

		myHand.addCard(card3);

		if (card2.equals(myHand.removeCard(1)) && myHand.getCard(1).equals(card3)) {
			System.out.println("Yay 2");
		}
		
		if ((myHand.indexOf(card1) == 0) && (myHand.indexOf(card2) == -1)) {
			System.out.println("Yay 3");
		}

	}

}