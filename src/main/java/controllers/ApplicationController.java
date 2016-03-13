/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result blackjack() {
        return Results.html().template("views/Blackjack/Blackjack.flt.html");
    }
    
    public Result gameGet(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();


        return Results.json().render(g);
    }
    public Result playerBet(Context context, @PathParam("bet1") int Bet, Game g){
        if(context.getRequestPath().contains("playerBet")){
            g.addBet(Bet);
        }
        return Results.json().render(g);
    }

    public Result ante(Context context, Game g){
        if(context.getRequestPath().contains("ante")){
            if(g.p.Bet == 0){                 //ensures ante can only be paid once at the beginning of a hand
                g.anteStart();
            }
        }
        return Results. json().render(g);
    }

    public Result doubleDown(Context context, Game g){
        if(context.getRequestPath().contains("doubleDown")){
            if(g.p.Bet > 0){
                g.doubleDown();
            }
        }
        return Results.json().render(g);
    }

    public Result hitPlayer(Context context, Game g) {
        if(context.getRequestPath().contains("hitPlayer")){
            g.hit(0);
        }
        return Results.json().render(g);
    }

    public Result stayPlayer(Context context, Game g) {
        if(context.getRequestPath().contains("stayPlayer")){
            g.stay(0);
        }
        return Results.json().render(g);
    }

    public Result foldPlayer(Context context, Game g) {
        if(context.getRequestPath().contains("foldPlayer")){
            g.fold();
        }
        return Results.json().render(g);
    }

    public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
            g.dealTwo();
        }
        return Results.json().render(g);
    }
}
