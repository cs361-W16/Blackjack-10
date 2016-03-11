package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class Game {

    public Deck d;
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public Game(){

        d = new Deck();

        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    public void buildDeck() {
        d.buildDeck();
    }

   public void shuffle() {
        d.shuffle();
    }

    public void dealTwo() {
        for (int i = 0; i < 2; i++) {
            cols.get(i).add(d.deal());
        }
    }

    private boolean colHasCards(int colNumber) {
        if(this.cols.get(colNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    private void addCardToCol(int colTo, Card cardToMove) {
        cols.get(colTo).add(cardToMove);
    }
}
