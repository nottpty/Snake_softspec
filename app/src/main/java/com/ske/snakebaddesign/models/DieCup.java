package com.ske.snakebaddesign.models;

/**
 * Created by SAS-Maxnot19 on 16/3/2559.
 */
public class DieCup {
    private Die die;
    private int face;

    public DieCup(){
        die = new Die();
    }

    public int roll(){
        return die.roll();
    }
}
