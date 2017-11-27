package com.firedevelop.id0000001.feature;

import java.util.Random;

public class Partida{
    public final int dificultad;
    public int jugador;
    private int[]CASILLAS;
    private static final int [] [] COMBINACIONES={{0,1,2},{3,4,5}};

    public Partida(int dificultad){
        this.dificultad=dificultad;
        jugador=1;
        CASILLAS=new int[9];
        for(int i=0;i<9;i++){
            CASILLAS[i]=0;
        }

    }
}