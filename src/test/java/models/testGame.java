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
        g.dealTwo();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
    }

    @Test
    public void testDealTwo() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealTwo();

        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());

        g.dealTwo();

        assertEquals(2,g.cols.get(0).size());
        assertEquals(2,g.cols.get(1).size());
    }

}
