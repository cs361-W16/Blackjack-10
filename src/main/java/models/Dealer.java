package models;

/**
 * Created by cody on 3/11/16.
 */


public class Dealer extends Actor{

    void play(int UserStay){
        if(sumHand() < 17){
            if(UserStay == 1){
                do{

                }while(sumHand() < 17);
            }

        }
    }
}
