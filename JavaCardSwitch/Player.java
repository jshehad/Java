/**************************************************************************
 * @author <Jihad Shehadeh>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Player.java
 *
 * Description: <INSERT DESCRIPTION>
 * 
 ***************************************************************************/
class Player <T extends Card> {
	
	// required fields
	private String name;
	private int points;
	private Hand<T> hand;	
	private Player<T> next;
	
	// TO DO: add your implementation and JavaDoc

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Player(String name){
		/**
		 * @param name of the player
		 * @param points keep track of score
		 * @param hand sets up the players hand
		 * @param next goes to the next player */
		//constructor
		this.name  = name;
		this.points = 0; // initializing
		this.hand = new Hand(); // initializing
		this.next = null; // initializing
	}
		
	public void setNext(Player<T> p){
		/**@param p sets a player to the game */
		// O(1)
		//set next player
		this.next = p;

	}
	
	public Player<T> getNext(){
		/**
		 * @return the next player */
		// O(1)
		//return next player
		return this.next;
	}

	public boolean hasNext() {
		/**@return boolean if there is a next player */
		// O(1)
		// whether there is a player after me
		if(getNext() == null) {
			return false;
		}
		return true;
	}

	public int getPoints(){
		/**
		 * @return points of player */
		// O(1)
		// return points of this player
		// determined by cards in hand
		return this.points;
	}
		
	public String getName(){
		/**
		 * @return name of player */
		// O(1)
		return this.name;
		// return name of the player
	}
	

	public boolean receiveCard(T c){
		/**
		 * @param c object of cards
		 * @return boolean if card was added to hand */
		// O(N)
		// receive a card and add it to hand
		// return?
		for (int i = 0; i < hand.numCards(); i++) {
			if (c.equals(hand.getCard(i)) == true) {
				return false;
			}

		}
		this.hand.addCard(c);
		this.points += c.getPoints();
		return true;
	}

	public boolean hasCard(T c) {
		/**@param c object of card
		 * @return boolean if player have card */
		// O(N)
		// return checking: whether we have the card in hand
		for (int i = 0; i < this.hand.numCards(); i++) {
			if (c.equals(this.hand.getCard(i)) == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean playCard(T c){
		/**
		 * @param c object of card
		 * @return boolean if play has been played */
		// O(N)
		// give away one card from hand
		// return false if card not present
		for (int i = 0; i < this.hand.numCards(); i++) {
			if (c.equals(this.hand.getCard(i)) == true) {
				this.hand.removeCard(c);
				this.points -= c.getPoints();
				return true;
			}
		}
		return false;
	}

	public T playCard(int index){
		/**
		 * @param index accept an integer
		 * @throw Runtime if integer is out of range */
		// O(1)
		// give away the card at index
		// throw RuntimeException for invalid index
		if ((index >= 0) && (index < this.hand.numCards())) {
			T tmp = this.hand.getCard(index);
			this.hand.removeCard(index);
			return tmp;
		}
		else {
			throw new RuntimeException();
		}

	}
	
	//---------------------------------------------------
	//example test code... edit this as much as you want!
	// you will need working CardSwitch and Hand classes to run the given code
	
	
	public String toString(){
		// Not required; edit for your own testing 
		return "Player "+ name;
	}


	public static void main(String[] args) {
		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");

		player1.receiveCard(card2);
		player1.receiveCard(card3);
		player2.receiveCard(card1);
		player1.setNext(player2);
		

		if (player1.getName().equals("Tom") && player1.getNext() == player2){
			System.out.println("Yay 1");
		}
		//System.out.println(player1.getNext().getNext());
		if (player1.hasCard(card2) == true && player1.getPoints() == 19){
			System.out.println("Yay 2");
		}
		System.out.println(player1.hasCard(card2));
		System.out.println(player1.getPoints());
		if ((player2.hasNext()==false) && player1.playCard(0) == card2){
			System.out.println("Yay 3");
		}
	
	}


}