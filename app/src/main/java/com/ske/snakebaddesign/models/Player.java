package com.ske.snakebaddesign.models;

/**
 * Created by SAS-Maxnot19 on 16/3/2559.
 */
public class Player {
    private Piece piece;

    public Player(){
        piece = new Piece();
    }

    public int getPosition(){
        return piece.getPosition();
    }

    public void setPosition(int pos){
        piece.setPosition(pos);
    }

}
