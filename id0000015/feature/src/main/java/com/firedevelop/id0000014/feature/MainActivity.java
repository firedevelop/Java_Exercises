package com.firedevelop.id0000014.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
    private int jugadores;
    private int [] casillas;
    private Partida partida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellenarTablaCasillas();
    }


    public void aJugar(View vista){
        ImageView imagen;
        for(int casilla:casillas){
            imagen = findViewById(casilla);
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
    }


    public void toque(View vista){
        if (partida == null) return;

        int casilla = 0;
        for(int i = 0; i < 9; i++){
            if( casillas[i] == vista.getId() ){
                casilla = i;
                break;
            }
        }
        
        if( partida.casillaOcupada(casilla) ){
            return;
        }

        marca(casilla);
        compruebaResultado();
        if(partida == null) return; // Si acaba la partida esta toma el valor de null.

        if(jugadores == 1) {
            casilla = partida.ia();
            marca(casilla);
            compruebaResultado();
        }

    }


    private void compruebaResultado(){
        int resultado = partida.turno();
        if( resultado > 0 ){
            termina(resultado);
        }
    }


    private void termina(int resultado) {
        String mensaje;
        if( resultado == 1 ) mensaje = getResources().getString(R.string.circulosGanan);
        else if( resultado == 2 ) mensaje = getResources().getString(R.string.aspasGanan);
        else mensaje = getResources().getString(R.string.empate);
        generarMensaje(mensaje);


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

    private void generarMensaje(String mensaje) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getResources().getString(R.string.resultado));
        alertDialogBuilder.setMessage(mensaje);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info);
        alertDialogBuilder.setPositiveButton(getResources().getString(R.string.aceptar),null);
        alertDialogBuilder.show();
    }

    private void marca(int casilla){
        ImageView imagen = findViewById(casillas[casilla]);
        if( partida.getJugador() == 1 ) {
            imagen.setImageResource(R.drawable.circulo);
        } else{
            imagen.setImageResource(R.drawable.aspa);
        }
    }



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
