package models;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created by cody on 3/11/16.
 */


public class Dealer extends Actor{
    int play(){
        java.util.List<Card> temp = getHand();
        int sum = 0;
        for(int i = 1; i < temp.size(); i++){
            sum += temp.get(i).getValue();
        }
        if(sum < 17){
            return 1;
        }
        else {
            return 0;
        }
    }

}
