package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by cody on 3/11/16.
 */
public class Actor {

    public int TotalMoney;
    public int Bet;
    public java.util.List<Card> hand = new ArrayList<>();

    void addCard(Card c){
        hand.add(c);
    }

    java.util.List<Card> getHand(){
        return hand;
    }

    Card getTop(){
        return hand.get(hand.size() - 1);
    }

    void resetHand() {
        hand = new ArrayList<>();
    }
}
