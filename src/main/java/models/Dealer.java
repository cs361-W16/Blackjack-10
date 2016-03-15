package models;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created by cody on 3/11/16.
 */


public class Dealer extends Actor{
    int play(){
        if(sumHand() < 17){
            return 1;
        }
        else {
            return 0;
        }
    }

}
