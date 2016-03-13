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
        p.TotalMoney = 100;
        p.Bet = 0;

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
            hit(0);             //two for the player, one for the dealer. easier than giving the dealer two and trying to hide one
            hit(0);
            hit(1);

    }

    public void addBet(int bet) {
        if(p.Bet > 0) {             //Ensures that the hand cannot progress until the player puts up the ante
            p.Bet = p.Bet + bet;
        }
    }
    public void doubleDown() {
        if(p.Bet > 0) {         //Ensures nothing can be done before the ante
            p.Bet = p.Bet + p.Bet;
            hit(0);
            stay(0);
        }
    }
    //Person = 0 mean Player, Person = 1 means Dealer
    public void hit(int Person) {
        if (p.Bet > 0) {            // ensures the player must pay ante before anything happens
            Card c = d.deal();
            cols.get(Person).add(c);

            if (Person == 1) e.addCard(c);

            else p.addCard(c);
        }
    }

    public void stay(int Person) {
       if (p.Bet > 0) {             //Ensures that the hand cannot progress until the player puts up the ante
           playDealer();
           getWinner();
           nextHand();
       }
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
        //Set player's bet pool to zero
        p.Bet = 0;
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

    }
    public void anteStart() {
        p.Bet = 2;
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
