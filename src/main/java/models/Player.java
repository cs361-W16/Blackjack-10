package models;

/**
 * Created by Charles on 3/13/16.
 */


public class Player extends Actor{

    public int TotalMoney;
    public int Bet;

    public Player(){
        TotalMoney = 100;
        Bet = 0;
    }
    public void addBet(int addbet){
        if(Bet > 0) {             //Ensures that the hand cannot progress until the player puts up the ante
            Bet = Bet + addbet;
        }
    }

    public void doubleDown() {
        if(Bet > 0) {         //Ensures nothing can be done before the ante
            Bet = Bet + Bet;
        }
    }   
}
