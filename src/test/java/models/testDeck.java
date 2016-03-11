package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paul on 2/17/16.
 */
public class testDeck {

    @Test
    public void testShuffle(){
        Deck d = new Deck();
        d.buildDeck();
        d.shuffle();
        assertNotEquals(2,d.deck.get(0).getValue());
    }

    @Test
    public void testDeal() {
        Deck d = new Deck();
        d.buildDeck();
        Card c = d.deal();
        assertEquals("14Spades", c.toString());
    }

}
