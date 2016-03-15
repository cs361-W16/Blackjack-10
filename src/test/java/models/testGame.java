package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.d.deck.size());
    }

    @Test
    public void testGameInit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(2,g.d.deck.get(0).getValue());
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();
        assertEquals(2,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
    }

    @Test
    public void testDealTwo() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();

        assertEquals(2,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());

        g.dealTwo();

        assertEquals(4,g.cols.get(0).size());
        assertEquals(2,g.cols.get(1).size());
    }

    @Test
    public void testHit(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.hit(0);
        assertEquals(1,g.cols.get(0).size());
        g.hit(1);
        assertEquals(1,g.cols.get(1).size());
    }

    @Test
    public void testStay(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();
        java.util.List<Card> hand = g.p.getHand();
        g.stay(0);
        assertNotEquals(hand, g.p.getHand());
    }

    @Test
    public void testFold(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();
        java.util.List<Card> hand = g.p.getHand();
        g.fold();
        assertNotEquals(hand, g.p.getHand());
    }

    @Test
    public void testNextHand(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();
        java.util.List<Card> hand = g.p.getHand();
        g.nextHand();
        assertNotEquals(hand, g.p.getHand());
    }

    @Test
    public void testColHasCards(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.p.Bet=10;
        g.dealTwo();
        assertEquals(true, g.colHasCards(0));
    }

    @Test
    public void testGetTopCard(){
        Game g = new Game();
        g.buildDeck();
        g.p.Bet=10;
        g.hit(0);
        assertEquals("14Spades", g.getTopCard(0).toString());
    }

    @Test
    public void testAddCardToCol(){
        Game g = new Game();
        Deck d = new Deck();
        d.buildDeck();
        Card c = d.deal();
        g.addCardToCol(0,c);
        assertEquals("14Spades", g.getTopCard(0).toString());
    }

    @Test
    public void testBetting(){
        Game g = new Game();
        assertEquals(0,g.p.Bet);
        g.p.Bet = 2;
        g.addBet(5);
        g.addBet(50);
        g.addBet(100);
        assertEquals(157,g.p.Bet);
    }

    @Test
    public void testDoubleDown(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        assertEquals(0,g.p.Bet);
        assertEquals(100,g.p.TotalMoney);
        g.p.Bet = 2;
        g.addBet(5);
        g.doubleDown();
        assertTrue((g.p.TotalMoney == 114) || (g.p.TotalMoney == 86));
    }

    @Test
    public void testAnte(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.hit(1);
        g.hit(0);
        assertEquals(false, g.colHasCards(0));
        assertEquals(false, g.colHasCards(1));
        g.dealTwo();
        assertEquals(false, g.colHasCards(0));
        assertEquals(false, g.colHasCards(1));
        g.addBet(10);
        assertEquals(0,g.p.Bet);
        g.anteStart();
        g.addBet(10);
        assertEquals(true, g.colHasCards(0));
        assertEquals(true, g.colHasCards(1));
        assertEquals(12,g.p.Bet);
    }
    @Test
    public void testGameWinner(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.hit(1);
        g.hit(1);
        g.hit(1);
        g.hit(1);
        g.hit(1);
        g.hit(0);
        g.getWinner();
        assertEquals(false,g.playerStatus);


    }
}
