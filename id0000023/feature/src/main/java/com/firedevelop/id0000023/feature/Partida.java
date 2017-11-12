package com.firedevelop.id0000023.feature;

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

    public int turno(){
        boolean empate=true;
        boolean ult_movimiento=true;
        for(int i=0;i<COMBINACIONES.length;i++){
            for(int pos:COMBINACIONES[i]){
                System.out.println("Valor en posición " + i + " " + casillas[pos]);
                if(casillas[pos]!=jugador)ult_movimiento=false;
                if(casillas[pos]==0){
                    empate=false;
                }
            }
            System.out.println("-------------------------------------------------");
            if(ult_movimiento)return jugador;
            ult_movimiento=true;

        }
        if(empate){
            return 3;
        }
        jugador++;
        if(jugador>2){
            jugador=1;
        }
        return 0;
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
    private static final int [][] COMBINACIONES = {
              {0,1,2}
            , {3,4,5}
            , {6,7,8}
            , {0,3,6}
            , {1,4,7}
            , {2,5,8}
            , {0,4,8}
            , {2,4,6}};
}



