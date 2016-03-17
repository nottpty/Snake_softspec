package com.ske.snakebaddesign.models;

import android.util.Log;

/**
 * Created by SAS-Maxnot19 on 16/3/2559.
 */
public class Die {
    private int face;

    public Die(){}

    public int roll(){
        face = (int)Math.round((Math.random()*5)+1);
        Log.e("face",face+"");
        return face;
    }
}
