package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class Game {

    public Deck d;
    public Player p;  //The player
    public Dealer e; //The dealer
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    public boolean playerStatus;
    public boolean dealerStatus;


    public Game(){

        d = new Deck();
        p = new Player();
        e = new Dealer();

        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        //another one for split hand array
        //cols.add(new ArrayList<Card>());
        //check to see if those two cards are the same, first rank and  then suit
        //if (ArrayList[0].rank == ArrayList[1].rank){
        //    if(ArrayList[0].suit == ArrayList[1].suit){
                //move the second card to the Split List
        //        cols.move(ArrayList<Card>, SplitList<Card>);
        //    }
            
        //}
    }
    //moving card from array list to split list
    /**public void move(ArrayList<Card>, SplitList<Card>) {
        Card cardToMove = getCard(ArrayList[1]);
        this.removeCardFromCol(ArrayList[1]);
        this.addCardToCol(SplitList[0],cardToMove);
    }
    //Getting the second card
    private Card getCard(ArrayList<Card>) {
        return this.cols.get(ArrayList[1]).get(this.cols.get(ArrayList[1]).size()-1);
    }
    //Adding card to split list
    private void addCardToCol(SplitList<Card>, Card cardToMove) {
        cols.get(SplitList<Card>).add(cardToMove);
    }
    //Removing Card from array list
    private void removeCardFromCol(ArrayList<Card>) {
        this.cols.get(ArrayList[1]).remove(this.cols.get(ArrayList[1]).size()-1);
    }**/

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

    public void addBet(int addbet) {p.addBet(addbet);}

    public void doubleDown() {
        p.doubleDown();
        hit(0);
        stay(0);
    }
    //Person = 0 mean Player, Person = 1 means Dealer
    public void hit(int Person) {
        if (p.Bet > 0) {            // ensures the player must pay ante before anything happens
            Card c = d.deal();
            cols.get(Person).add(c);

            if (Person == 1 && e.play() == 1) {
                    e.addCard(c);
                    if(e.sumHand() > 21){
                        getWinner();

                    }
            }

            else p.addCard(c);
        }
    }
    
    /**
     * Created by Natasha
     */
    //public interface Player {
        //public int total();
        //void hit(Card card); // returns hand total
        //public Player split(); // produces two hands
    //}
    //public int total(int Person){
    //    if (cols.get(Person).card.value == cols.get(Person).card2.value)
    //          return TRUE;
    //}

    //@Override
    //public Player split() {
        // Check if hand can be split. Need to make sure that the two cards same value. player can only have two cards
        //total = total / 2;

    //    Hand splitHand = new Hand(new Card.value);
    //    splitHand.hit(); // Add a card to the splitHand
    //    hit(); // add new card to the current hand
    //    return splitHand;
    //}

    public void stay(int Person) {
       if (p.Bet > 0) {             //Ensures that the hand cannot progress until the player puts up the ante
           while(e.play() < 17){
               hit(1);
           }
           hit(1); //This makes up for the first one not being there
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

    //Determine winner and add or subtract pot from winnings
    public void getWinner() {

        //p.TotalMoney = p.TotalMoney + p.Bet;    //feel free to get rid of this when you implement. i just needed it gor a test - Charles

        if (p.sumHand() > e.sumHand()){
            if (p.sumHand() < 22){
                playerStatus = true;
                dealerStatus = false;
                p.TotalMoney = p.TotalMoney + p.Bet;
            }
            else{
                dealerStatus = true;
                playerStatus = false;
                p.TotalMoney = p.TotalMoney - p.Bet;

            }
        }
        else{
            if (e.sumHand() > 21){
                playerStatus = true;
                dealerStatus = false;
                p.TotalMoney = p.TotalMoney + p.Bet;
            }
            else {
                dealerStatus = true;
                playerStatus = false;
                p.TotalMoney = p.TotalMoney - p.Bet;
            }
        }

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
