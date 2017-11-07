package com.firedevelop.id0000014.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
    // almacenamos cuantos jugadores van a intervenir en la partida
    private int jugadores;
    // para saber e identificar en cual de las 9 casillas se ha hecho clic
    private int [] casillas;
    // vamos a trabarjar con modularizacion, por lo tanto crearemos otro archivo llamado Partida.java
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellenarTablaCasillas();
    }

    /**
     * Metodo que es llamado para al pulsar el boton de 1 jugador o 2 jugadores.
     * @param vista La vista del boton pulsado.
     */
    public void aJugar(View vista){
        // identifico a cada casilla con una imagen
        ImageView imagen;
        // aqui recorro el array casillas elemento a elemento
        for(int casilla:casillas){
            // almaceno el Id de cada casilla dentro de esta variable llamada imagen
            imagen = findViewById(casilla);
            // a cada vuelta de imagen, cuando estemos en el bucle evaluando una a una cada casilla, le asignaremos la casilla en blanco para limpiar el tablero
            imagen.setImageResource(R.drawable.casilla);
        }

        jugadores = (vista.getId() == R.id.dosJugador) ? 2 : 1;
        if (vista.getId() == R.id.dosJugador){
            jugadores = 2;
            findViewById(R.id.unJugador).setAlpha(0);
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.normal).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        } else {
            jugadores = 1;
            findViewById(R.id.dosJugador).setAlpha(0);
        }

        RadioGroup configDificultad = findViewById(R.id.configDificultad);
        int id = configDificultad.getCheckedRadioButtonId();

        int dificultad;

        if (id == R.id.normal) {
            dificultad = 1;
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        }
        else if (id == R.id.imposible) {
            dificultad = 2;
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.normal).setAlpha(0);
        }
        else {
            dificultad = 0;
            findViewById(R.id.normal).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        }

        partida = new Partida(dificultad);
        findViewById(R.id.unJugador).setEnabled(false);
        findViewById(R.id.facil).setEnabled(false);
        findViewById(R.id.normal).setEnabled(false);
        findViewById(R.id.imposible).setEnabled(false);
        findViewById(R.id.dosJugador).setEnabled(false);
        //((RadioGroup) findViewById(R.id.configDificultad)).setAlpha(0);
    }

    /**
     * Metodo que realiza las tareas correspondientes cuando el jugador pulsa una casilla.
     * @param vista La vista de la casilla pulsada.
     */
    public void toque(View vista){
        // Si no se ha iniciado la partida que no haga nada.
        if (partida == null) return;

        int casilla = 0;
        for(int i = 0; i < 9; i++){
            if( casillas[i] == vista.getId() ){
                casilla = i;
                break;
            }
        }

        // Mostrar un mensaje de tipo Toast
        //Toast.makeText(this , "Has pulsado la casilla " + casilla, Toast.LENGTH_SHORT).show();

        if( partida.casillaOcupada(casilla) ){
            return;
        }

        marca(casilla);
        //partida.turno();
        compruebaResultado();
        if(partida == null) return; // Si acaba la partida esta toma el valor de null.

        if(jugadores == 1) {
            casilla = partida.ia();
            marca(casilla);
            //partida.turno();
            compruebaResultado();
        }

    }

    /**
     * Metodo que comprueba el resultado que da el turno da por terminada la partida.
     */
    private void compruebaResultado(){
        int resultado = partida.turno();
        if( resultado > 0 ){
            termina(resultado);
        }
    }

    /**
     * Metodo que realiza las tareas necesaria cuando se finaliza la partida.
     * @param resultado Entero que representa el resultado de la partida.
     *                  1 = Círculos, 2 = Aspas, 3 = Empate.
     */
    private void termina(int resultado) {
        String mensaje;
        if( resultado == 1 ) mensaje = getResources().getString(R.string.circulosGanan);
        else if( resultado == 2 ) mensaje = getResources().getString(R.string.aspasGanan);
        else mensaje = getResources().getString(R.string.empate);
        generarMensaje(mensaje);

        //Toast.makeText(this , mensaje, Toast.LENGTH_SHORT).show();

        partida = null;
        findViewById(R.id.unJugador).setEnabled(true);
        findViewById(R.id.unJugador).setAlpha(1);

        findViewById(R.id.facil).setAlpha(1);
        findViewById(R.id.facil).setEnabled(true);
        findViewById(R.id.normal).setAlpha(1);
        findViewById(R.id.normal).setEnabled(true);
        findViewById(R.id.imposible).setAlpha(1);
        findViewById(R.id.imposible).setEnabled(true);

        findViewById(R.id.dosJugador).setEnabled(true);
        findViewById(R.id.dosJugador).setAlpha(1);

        findViewById(R.id.configDificultad).setAlpha(1);
    }

    /**
     * Metodo para generar un mensaje. Se utiliza al terminar la partida.
     * @param mensaje Cadena de texto que mostrara el mensaje.
     */
    private void generarMensaje(String mensaje) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.resultado));
        alertDialogBuilder.setMessage(mensaje);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info);
        alertDialogBuilder.setPositiveButton(getResources().getString(R.string.aceptar),null);
        alertDialogBuilder.show();
    }

    /**
     * Metodo para marcar con la marca que corresponde a cada jugador.
     * @param casilla Entero con la casilla a marcar.
     */
    private void marca(int casilla){
        ImageView imagen = findViewById(casillas[casilla]);
        if( partida.getJugador() == 1 ) {
            imagen.setImageResource(R.drawable.circulo);
        } else{
            imagen.setImageResource(R.drawable.aspa);
        }
    }


    //Metodo que se encarga de rellenar la tabla o array que almacenara todas la casillas
    // iniciamos el array casillas que identifica cada casilla y la almacena en el array

    private void rellenarTablaCasillas(){
        casillas = new int[9];
        casillas[0] = R.id.a1;
        casillas[1] = R.id.a2;
        casillas[2] = R.id.a3;
        casillas[3] = R.id.b1;
        casillas[4] = R.id.b2;
        casillas[5] = R.id.b3;
        casillas[6] = R.id.c1;
        casillas[7] = R.id.c2;
        casillas[8] = R.id.c3;
    }

}
