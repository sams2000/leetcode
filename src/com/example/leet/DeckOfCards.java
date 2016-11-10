package com.example.leet;
enum Rank { 
	   DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE 
	}

enum Suit { 
	   DIAMONDS, CLUBS, HEARTS, SPADES 
	}	

class Card {
 private final Rank rank;
 private final Suit suit;

 public Card(Rank rank, Suit suit) {
     this.rank = rank;
     this.suit = suit;
 }

 public Suit getSuit() {
     return suit;
 }

 public Rank getRank() {
     return rank;
 }

 public String toString() {
     return rank + " of " + suit;
 }
}

public class DeckOfCards {
	 private static Card[] cards = new Card[52];
	 public DeckOfCards() {
	     int i = 0;
	     for (Suit suit : Suit.values()) {
	         for (Rank rank : Rank.values()) {
	             cards[i++] = new Card(rank, suit);
	         }
	     }
	 }

	 public static void main(String arg[]){
		 new DeckOfCards();
		 int count=1;
		 for (Card card : cards)
			 System.out.println("Index of " + count++ + " " + card.toString());
	 }	 
}
