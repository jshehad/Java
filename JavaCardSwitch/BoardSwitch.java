/**************************************************************************
 * @author <Jihad Shehadeh>
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: BoardSwitch.java
 *
 * Description: <INSERT DESCRIPTION>
 * 
 ***************************************************************************/
public class BoardSwitch<T extends Card> extends Board<T>{
	
	// TO DO: add your implementation and JavaDoc
	
	public BoardSwitch(Deck<T> deck){
		/**
		 * @param deck create a deck of cards */
		//constructor
		//start with zero players
		super(deck);
		this.numPlayer = 0;
	}
	
	public Player<T> getCurrentPlayer() {
		/**
		 * @return current player */
		// return the current player
		// O(1)
		return this.currentPlayer;
		
	}


	public int getNumPlayers() {
		/**
		 * @return numPlayer number of players */
		// return how many players 
		// O(1)
		return this.numPlayer;
	}
	
	public Deck<T> getDeck(){
		/**
		 * @return deck */
		//return the current deck
		// O(1)
		return this.deck;
	}

	public boolean changeTurn() {
		/**
		 * @return boolean if there is a next player, if true it will changeTurn */
		// move the current player to the next one in the linked list
		// return false if cannot change
		// O(1)
		if (this.currentPlayer.hasNext() == true) {
			this.currentPlayer = this.currentPlayer.getNext();
		    return true;
		}
		return false;
	}
	
	@Override
	public void addPlayer(Player<T> x) {
		/**
		 * @param x adds player to board */
		// add another player in the linked list
		// should add to the left of currentPlayer
		// O(N)
		Player<T> head = getCurrentPlayer(); // start
		Player<T> pointer = head;
		Player<T> addingPlayer = x;
		this.numPlayer++;
		
		if(head == null) { // no players in game make x the first player
			this.currentPlayer = x;
			this.currentPlayer.setNext(this.currentPlayer);
			return;
		}
		while(pointer.getNext() != head) { // else add player at the end of current player
			pointer = pointer.getNext();
		}
		addingPlayer.setNext(head);
		pointer.setNext(addingPlayer);
	}
	
	public Player<T> findWinner(){
		/**
		 * @return finWinner player with the highest score */
		// return the player with the highest point
		// O(N)
		Player<T> head = getCurrentPlayer(); // start
		Player<T> totalPoints = head;
		Player<T> next = head.getNext();
		while(next.getNext() != head) {
			if((totalPoints.getPoints() < next.getPoints()) == true) { // if first player is less than the next player
				totalPoints = next;
				next = next.getNext();
			}
			else if ((totalPoints.getPoints() > next.getPoints()) == true){ // if first player is greater than the next player
				totalPoints = head;
				next = next.getNext();
			}
			//else if(totalPoints.getPoints() == next.getPoints()) {
			//}
		}
		
		return totalPoints;
	}

	//-----------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need working CardSwitch, Hand, Player, Deck and PlaySwitch classes to run the given code
	
	public static void main(String[] args) {
		Deck<CardSwitch> deck = new Deck<CardSwitch>();
		PlaySwitch.init_deck(deck);
			
		BoardSwitch<CardSwitch> myBoard = new BoardSwitch<CardSwitch>(deck);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");
		Player<CardSwitch> player3 = new Player<CardSwitch>("Danny");
		Player<CardSwitch> player4 = new Player<CardSwitch>("Jonny");

		myBoard.addPlayer(player1);
		
		if (myBoard.getNumPlayers() ==1  && myBoard.getCurrentPlayer() == player1
			&& player1.getNext() == player1){
			System.out.println("Yay 1");
		}

		myBoard.addPlayer(player2);
		
		if (myBoard.getNumPlayers() ==2  && myBoard.getCurrentPlayer() == player1
			&& (myBoard.changeTurn()==true) && myBoard.getCurrentPlayer() == player2){
			System.out.println("Yay 2");
		}
		
		player1.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES));
		player1.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.CLUBS));
		player2.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS));
		player2.receiveCard(new CardSwitch(Card.Rank.THREE, Card.Suit.SPADES));
		player3.receiveCard(new CardSwitch(Card.Rank.TEN, Card.Suit.HEARTS));
		player3.receiveCard(new CardSwitch(Card.Rank.FOUR, Card.Suit.SPADES));
		player4.receiveCard(new CardSwitch(Card.Rank.KING, Card.Suit.HEARTS));
		player4.receiveCard(new CardSwitch(Card.Rank.FIVE, Card.Suit.SPADES));
		
		if (player1.getNext() == player2 && player2.getNext() == player1
			&& myBoard.findWinner() == player2){
			System.out.println("Yay 3");
		}
		myBoard.addPlayer(player3);
		
		if (player1.getNext() == player3 && player3.getNext() == player1
				&& myBoard.findWinner() == player3){
				System.out.println("Yay 4");
			}
		
		myBoard.addPlayer(player4);
		
		if (player3.getNext() == player4 && player4.getNext() == player3
				&& myBoard.findWinner() == player4){
				System.out.println("Yay 5");
		}
		System.out.println(player4.getNext());
	}

}
