package models;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Created by cody on 3/14/16.
 */
public class testDealer{
    @Test
    public void testDealerStop(){
        Dealer d = new Dealer();
        Card c = new Card(1, Suit.Spades);


        while(d.play() == 1){
            d.addCard(c);
        }

        d.addCard(c);
        assertEquals(d.play(), 0);
    }
    @Test
    public void testDealerPlay(){
        Dealer d = new Dealer();
        Card c = new Card(1, Suit.Spades);



        d.addCard(c);
        assertEquals(d.play(), 1);
    }
}
