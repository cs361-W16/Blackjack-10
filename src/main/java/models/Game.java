package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class Game {

    public Deck d;
    public Actor p;  //The player
    public Dealer e; //The dealer
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public Game(){

        d = new Deck();
        p = new Actor();
        e = new Dealer();

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
        hit(0);
        hit(0);
        hit(1);
        hit(1);
    }

    //Person = 0 mean Player, Person = 1 means Dealer
    public void hit(int Person) {
        Card c = d.deal();
        cols.get(Person).add(c);

        if (Person == 1)
            e.addCard(c);
        else p.addCard(c);
    }

    public void stay(int Person) {
        playDealer();
        getWinner();
        nextHand();
    }

    public void fold() {
        //Set players hand to 0 so they will always lose
        p.resetHand();
        getWinner();
        nextHand();
    }
    //Behavior for dealer
    public void playDealer() {
    //Cody should fill this in
    }

    //Determine winner and add or subtract pot from winnings
    public void getWinner() {
    //Nawaf should fill this in
    }

    //Add used cards back to deck and set up next hand
    public void nextHand() {

        //Remove hand from player and dealer
        p.resetHand();
        e.resetHand();

        //reset deck and reshuffle
        d.resetDeck();
        d.shuffle();

        //reset view
        cols = new ArrayList<>();
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());

        //Deal new hand
        dealTwo();
    }


    public boolean colHasCards(int colNumber) {
        if(this.cols.get(colNumber).size()>0){
            return true;
        }
        return false;
    }

    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    public void addCardToCol(int colTo, Card cardToMove) {
        cols.get(colTo).add(cardToMove);
    }

}
