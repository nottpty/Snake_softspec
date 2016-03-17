package com.ske.snakebaddesign.models;

/**
 * Created by SAS-Maxnot19 on 16/3/2559.
 */
public class Piece {
    private int pos;

    public Piece(){
        pos = 0;
    }

    public int getPosition(){
        return pos;
    }

    public void setPosition(int pos){
        this.pos = pos;
    }
}
