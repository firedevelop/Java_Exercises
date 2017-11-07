package com.firedevelop.id0000014.feature;
import java.util.Random;

/**
 * Clase que controla una partida.
 * Created by Inaxio on 15/06/2017.
 */

public class Partida {

    private final int DIFICULTAD;
    private int jugador;
    private int [] marcadas;
    private static final int [][] COMBINACIONES = {{0,1,2}
            , {3,4,5}
            , {6,7,8}
            , {0,3,6}
            , {1,4,7}
            , {2,5,8}
            , {0,4,8}
            , {2,4,6}};
    /**
     * Constructor
     */
    public Partida(int dificultad){
        this.DIFICULTAD = dificultad;
        jugador = 1;
        rellenarTablaMarcadas();
    }

    /**
     * Metodo que cambia el turno del jugador.
     */
    public int turno()
    {
        boolean empate = true;
        boolean ultimoMovimiento = true;
        for (int[] combinacion : COMBINACIONES) {
            for (int pos : combinacion) {
                if (marcadas[pos] != jugador) ultimoMovimiento = false;
                if (marcadas[pos] == 0) empate = false;
            } // fin for anidado
            if (ultimoMovimiento) return jugador;
            ultimoMovimiento = true;
        } // fin for principal

        if( empate ) return 3;

        jugador = ( jugador == 1 ) ? 2 : 1;

        return 0;
    }

    /**
     * Metodo que comprueba si hay una casilla con opción a tres en raya.
     * @param jugadorEnTurno Jugador que tiene el turno.
     * @return devuelve la casilla que tiene la opción de tres en raya o -1 si no hay opción.
     */
    private int dosEnRaya(int jugadorEnTurno){
        int casilla = -1;
        int cuantasLleva = 0;
        for (int[] combinacion : COMBINACIONES) {
            for (int pos : combinacion) {
                if (marcadas[pos] == jugadorEnTurno) cuantasLleva++;
                if (marcadas[pos] == 0) casilla = pos;
            } // fin for anidado
            if (cuantasLleva == 2 && casilla != -1) return casilla;
            casilla = -1;
            cuantasLleva = 0;
        } // fin for principal

        return -1;
    }

    /**
     * Método para juegue la IA.
     * @return devuelve una casilla en función del nivel de juego.
     *                  0 => no gana nadie.
     *                  1 => gana el jugador 1.
     *                  2 => gana el jugador 2.
     *                  3 => hay un empate.
     */
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

    /**
     * Metodo que comprueba si la casilla no esta utilizada. Si la casilla esta libre, se la asigna
     * al jugador que ha marcado la casilla.
     * @param casilla casilla marcada por el jugador.
     * @return devuelve true si la operación se ha completado o false si la casilla estaba utilizada.
     */
    public boolean casillaOcupada(int casilla){
        if(marcadas[casilla] != 0){
            return true;
        } else {
            marcadas[casilla] = jugador;
        }
        return false;
    }

    /**
     * Metodo que se encarga de rellenar la tabla o array que almacenara todas la casillas.
     */
    private void rellenarTablaMarcadas(){
        marcadas = new int[9];
        for(int i = 0; i < marcadas.length; i++){
            marcadas[i] = 0;
        }
    }

    /**
     * Metodo para obtener el jugador en curso.
     * @return Entero con el jugador 1 o 2.
     */
    public int getJugador(){
        return jugador;
    }

}
