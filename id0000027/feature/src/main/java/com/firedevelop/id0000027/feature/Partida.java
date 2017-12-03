package com.firedevelop.id0000027.feature;

import java.util.Random;

public class Partida{
    public final int dificultad;
    public int jugador;
    private  int [] CASILLAS;
    private static final int [][] COMBINACIONES = {{0,1,2}, {4,5,3}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public Partida(int dificultad){
        this.dificultad=dificultad;
       jugador=1;
        /**
         * Rellena todas las CASILLAS a cero:
         * Casillas[0]=0
         * Casillas[1]=0
         * ...
         * para que en el metodo comprueba_casilla sepamos si esta marcada o no.
         */
        CASILLAS =new int[9];
        for(int i=0;i<9;i++){
            CASILLAS[i]=0;
        }
    }

    /**
     * aqui la variable "casilla" que le pasamos de MainActivity, se va a usar para determinar cual es el indice del array es decir:
     * si le pasamos 3, lo que va a hacer es mirar cual es el valor del indice del array CASILLAS[3] que por defecto al iniciar la partida sera CASILLAS[3]=0
     * Pero en cuanto se marque 1 sola vez dicho indice del array va a rellenarse con el valor del jugador es decir si es el jugador 2 el que ha pulsado seria  CASILLAS[3]=2
     */
    public boolean comprueba_casilla(int casilla){
        if(CASILLAS[casilla]!=0){
            return false;
        }else {
            CASILLAS[casilla]=jugador;
        }
        return true;
    }

    public int turno(){
        boolean empate=true;
        boolean ult_movimiento=true;
        System.out.println("*********** JUGADOR "+jugador+"***********"+"ult_movimiento="+ult_movimiento+ " empate="+empate+" jugador="+jugador);
        for(int i=0;i<COMBINACIONES.length;i++){
            for(int pos:COMBINACIONES[i]){
                System.out.println("Valor en posicion " + pos + " " + CASILLAS[pos]);
                if(CASILLAS[pos]!=jugador)ult_movimiento=false;
                /**
                 * Si nos damos cuenta y estamos al principio o en mitad de una partida, podemos ver como en el  array
                 casillas[...]=0
                 hay ceros lo que está indicando que son casillas sin marcar, por lo tanto siempre que el condidional if encuentre un cero va saber que la partida no ha terminado y por lo tanto no puede haber nunca un empate, y por lo tanto lo declara como false:
                 empate=false
                 */
                if(CASILLAS[pos]==0){
                    empate=false;
                }
            }
            System.out.println("-------------------------------------------------"+"ult_movimiento="+ult_movimiento+" empate="+empate+" jugador="+jugador);
            if(ult_movimiento)return jugador;
            System.out.print("ult_movimiento after pos= " + ult_movimiento + "\n");
            ult_movimiento=true;
        }
        if(empate){
            return 3;
        }
        jugador++;
        if(jugador>2){
            jugador=1;
        }
        /**
         * este return lo vamos a utilizar para saber si la partida ha terminado. Y vamos a decirle que nos devuelva cero si la partida no a terminado, con return 0
         */
        return 0;
    }
// Explicacion de este metodo justo aqui: https://youtu.be/TGg9uQmB4pc?t=20m11s
    public int dosEnRaya(int jugador_en_turno){
        int casilla=-1;
        int cuantas_lleva=0;
        for (int i=0;i<COMBINACIONES.length;i++){
            for(int pos:COMBINACIONES[i]){
                if(CASILLAS[pos]==jugador_en_turno)cuantas_lleva++;
                if(CASILLAS[pos]==0)casilla=pos;
            }
            if(cuantas_lleva==2 && casilla!=-1)return casilla;
            casilla=-1;
            cuantas_lleva=0;
        }
        return -1;
    }

    public int ia(){
        int casilla;
        casilla=dosEnRaya(2);
        if(casilla!=-1)return casilla;
        if(dificultad>0){
            casilla=dosEnRaya(1);
            if(casilla!=-1)return casilla;
        }
        if(dificultad==2){
            if(CASILLAS[0]==0)return 0;
            if(CASILLAS[2]==0)return 2;
            if(CASILLAS[6]==0)return 6;
            if(CASILLAS[8]==0)return 8;
        }
        Random casilla_azar=new Random();
        casilla=casilla_azar.nextInt(9);
        return casilla;
    }
}

