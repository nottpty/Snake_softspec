package com.ske.snakebaddesign.models;

import android.content.DialogInterface;
import android.util.Log;

import com.ske.snakebaddesign.guis.BoardView;

import java.util.Observable;

/**
 * Created by SAS-Maxnot19 on 16/3/2559.
 */
public class Game extends Observable{
    private int turn;
    private DieCup dieCup;
    private Player player[];
    private int boardSize;
    private int face;

    public Game(int numPlayer,int boardSize){
        player = new Player[numPlayer];
        for(int i = 0 ; i<numPlayer ; i++){
            player[i] = new Player();
        }
        dieCup = new DieCup();
        turn = 0;
        this.boardSize = boardSize;

    }

    public void rollDice(){
        face = dieCup.roll();
        turn++;
        Log.e("position",""+player[0].getPosition());
        Log.e("face",""+face);
        this.setChanged();
        this.notifyObservers();
    }

    public void setPosition(){
        if (turn % 2 == 0) {
            player[0].setPosition(AdjustPosition(player[0].getPosition(),face));
        } else {
            player[1].setPosition(AdjustPosition(player[1].getPosition(),face));
        }
    }

    public int getFace(){
        return face;
    }

    public Player[] getPlayer(){
        return player;
    }

    public String getWinner(){
        for(int i = 0 ; i < player.length ; i++){
            if(player[i].getPosition() == boardSize * boardSize - 1){
                return "player"+(i);
            }
        }
        return "";
    }

    public void resetGame() {
        turn = 0;
        for(int i = 0 ; i < 2 ; i++){
            player[i].setPosition(0);
        }
        boardSize = 6;
    }

    public int getTurn(){
        return turn;
    }

    public int AdjustPosition(int current, int distance){
        current = current + distance;
        int maxSquare = boardSize * boardSize - 1;
        if(current > maxSquare) {
            current = maxSquare - (current - maxSquare);
        }
        Log.e("current",current+"");
        Log.e("distance",distance+"");
        Log.e("maxSquare",maxSquare+"");
        return current;
    }
}
