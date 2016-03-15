package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by paul on 2/17/16.
 */
public class Deck {

    public java.util.List<Card> deck = new ArrayList<>();

    public void buildDeck(){
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }

    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public Card deal() {
        Card c = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return c;
    }

    public void resetDeck () {
        deck = new ArrayList<>();
        buildDeck();
    }
}
