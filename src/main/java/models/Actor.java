package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by cody on 3/11/16.
 */
abstract class Actor {
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

    int sumHand() {
        int total = 0;
        for (Card temp : hand) {
            total += temp.getValue();
        }
        return total;
    }
    void resetHand(){
        hand = new ArrayList<>();
    }
}
