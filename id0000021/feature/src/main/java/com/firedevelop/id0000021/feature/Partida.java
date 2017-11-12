package com.firedevelop.id0000021.feature;

import java.util.Random;

public class Partida{
    public Partida(int dificultad){
        this.dificultad=dificultad;
        jugador=1;
        casillas=new int[9];
        for(int i=0;i<9;i++){
            casillas[i]=0;
        }
    }
    public boolean comprueba_casilla(int casilla){
        if(casillas[casilla]!=0){
            return false;
        }else {
            casillas[casilla]=jugador;
        }
        return true;
    }

    public void turno(){
        jugador++;
        if(jugador>2){
            jugador=1;
        }
    }

    public int ia(){
        int casilla;
        Random casilla_azar=new Random();
        casilla=casilla_azar.nextInt(9);
        return casilla;
    }

    public final int dificultad;
    public int jugador;
    private  int [] casillas;
}



