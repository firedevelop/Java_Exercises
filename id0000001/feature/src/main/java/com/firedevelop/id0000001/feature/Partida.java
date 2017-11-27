package com.firedevelop.id0000001.feature;

import java.util.Random;

public class Partida{
    public final int dificulad;
    public int jugador;
    private int [] CASILLAS;
    private static final int [][]COMBINACIONES={{0,1,2},{3,4,5}};

    public Partida(int dificulad){
        this.dificulad=dificulad;
        jugador=1;

        CASILLAS=new int[9];
        for(int i=0;i<9;i++){
            CASILLAS[i]=0;
        }
    }
    public boolean comprueba_casilla(int casilla){
        if(CASILLAS[casilla]!=0){
            return false;
        }else{
            CASILLAS[casilla]=jugador;
        }
        return true;
    }

}