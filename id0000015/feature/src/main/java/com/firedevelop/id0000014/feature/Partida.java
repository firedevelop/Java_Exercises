package com.firedevelop.id0000014.feature;
import java.util.Random;

public class Partida {
    private final int DIFICULTAD;
    private int jugador;
    private int [] marcadas;
    private static final int [][] COMBINACIONES= {
              {0,1,2}
            , {3,4,5}
            , {6,7,8}
            , {0,3,6}
            , {1,4,7}
            , {2,5,8}
            , {0,4,8}
            , {2,4,6}
    };

    public Partida(int dificultad){
        this.DIFICULTAD = dificultad;
        jugador = 1;
        rellenarTablaMarcadas();
    }

    public int turno()
    {
        boolean empate = true;
        boolean ultimoMovimiento = true;
        for (int[] combinacion : COMBINACIONES) {
            for (int pos : combinacion) {
                if (marcadas[pos] != jugador) ultimoMovimiento = false;
                if (marcadas[pos] == 0) empate = false;
            }
            if (ultimoMovimiento) return jugador;
            ultimoMovimiento = true;
        }

        if( empate ) return 3;

        jugador = ( jugador == 1 ) ? 2 : 1;

        return 0;
    }


    private int dosEnRaya(int jugadorEnTurno){
        int casilla = -1;
        int cuantasLleva = 0;
        for (int[] combinacion : COMBINACIONES) {
            for (int pos : combinacion) {
                if (marcadas[pos] == jugadorEnTurno) cuantasLleva++;
                if (marcadas[pos] == 0) casilla = pos;
            }
            if (cuantasLleva == 2 && casilla != -1) return casilla;
            casilla = -1;
            cuantasLleva = 0;
        }

        return -1;
    }


    public int ia(){
        int casilla;

        casilla = dosEnRaya(2);
        if( casilla != -1){
            marcadas[casilla] = jugador;
            return casilla;
        }

        if(DIFICULTAD > 0){
            casilla = dosEnRaya(1);
            if( casilla != -1){
                marcadas[casilla] = jugador;
                return casilla;
            }
        }

        if(DIFICULTAD == 2){
            int [] cas = {4, 0, 2, 6, 8};
            for(int c:cas)
                if( ! casillaOcupada(c) ) return c;
        }

        Random azar = new Random();
        do{
            casilla = azar.nextInt(9);
        }while ( casillaOcupada(casilla) );
        marcadas[casilla] = jugador;
        return casilla;
    }


    public boolean casillaOcupada(int casilla){
        if(marcadas[casilla] != 0){
            return true;
        } else {
            marcadas[casilla] = jugador;
        }
        return false;
    }


    private void rellenarTablaMarcadas(){
        marcadas = new int[9];
        for(int i = 0; i < marcadas.length; i++){
            marcadas[i] = 0;
        }
    }

    public int getJugador(){
        return jugador;
    }

}
