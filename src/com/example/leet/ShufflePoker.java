package com.example.leet;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely. 
 * Assume that you are given a random number generator which is perfect.
 * @author bin zhou
 * @since 2013-07-21
 *
 */
import java.util.Random;

public class ShufflePoker {
	static final int COUNT = 52;//cards usually have 52 
	
	public static void main(String[] args) {
		
		int[] cards = new int[COUNT];
		for (int i=0; i<COUNT; i++)
			cards[i] = i;
		
		shuffleArray(cards);
		
		for (int card : cards)
			System.out.print(card + ", ");

	}

	private static void shuffleArray(int[] cards){
		int temp, randomIndex;
		for (int i=0; i<cards.length; i++){
			Random random = new Random();
			randomIndex = random.nextInt(COUNT-i) + i;
			
			//swap selected element with current element at position i
			temp = cards[i];
			cards[i] = cards[randomIndex];
			cards[randomIndex] = temp;
		}
	}
}
