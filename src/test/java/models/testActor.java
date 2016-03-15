package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by paul on 3/11/16.
 */
public class testActor {

    @Test
    public void testAddCard() {
        Player a = new Player();
        Deck d = new Deck();
        d.buildDeck();
        Card c = d.deal();
        a.addCard(c);
        Card v = a.getTop();
        assertEquals("14Spades",v.toString());
    }

    @Test
    public void testGetHand() {
        Player a = new Player();
        Deck d = new Deck();
        d.buildDeck();
        Card c = d.deal();
        a.addCard(c);

        java.util.List<Card> hand;
        hand = a.getHand();

        Card v = hand.get(0);
        assertEquals("14Spades",v.toString());
    }

    @Test
    public void testResetHand() {
        Player a = new Player();
        Deck d = new Deck();
        d.buildDeck();
        d.shuffle();
        Card c = d.deal();
        a.addCard(c);
        Card v = a.getTop();
        a.resetHand();
        assertEquals(a.getHand().size(),0);
    }
}
