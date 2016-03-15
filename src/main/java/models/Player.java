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
    /**
    * Created by Natasha
     * Nawwaf is writing the hit and stay functions but I need them to use this.
     */
    public interface IBlackJackHand {
        public int total();
        public void stay();
        int hit(Card card); // returns hand total
        public IBlackJackHand split(); // produces two hands
    }

    @Override
    public IBlackJackHand split() {
        // Check if hand can be split. Need to make sure that the two cards same value
        total = total / 2;

        IBlackJackHand splitHand = new IBlackJackHand(new Card(total));
        splitHand.hit(); // Add a card to the splitHand
        hit(); // add new card to the current hand
        return splitHand;
    }
}
