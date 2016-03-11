package models;

import java.util.ArrayList;

/**
 * Created by cody on 3/11/16.
 */
public class Actor {
    private java.util.List<Card> hand = new ArrayList<>();

    void addCard(Card c){
        hand.add(c);
    }

    java.util.List<Card> getHand(){
        return hand;
    }

    Card getTop(){
        return hand.get(hand.size() - 1);
    }
}
