package com.firedevelop.id0000014.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
   private int jugadores;
   private int []casillas;
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
            imagen=findViewById(casilla);
            imagen.setImageResource(R.drawable.casilla);
        }
        jugadores=(vista.getId()==R.id.dosJugador)?2:1;
        if(vista.getId()==R.id.dosJugador){
            jugadores=2;
            findViewById(R.id.unJugador).setAlpha(0);
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.normal).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        }else {
            jugadores=1;
            findViewById(R.id.dosJugador).setAlpha(0);
        }
        RadioGroup configDificultad=findViewById(R.id.configDificultad);
        int id=configDificultad.getCheckedRadioButtonId();
        int dificultad;
        if(id==R.id.normal){
            dificultad=1;
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        }else if (id==R.id.imposible){
            dificultad=2;
            findViewById(R.id.facil).setAlpha(0);
            findViewById(R.id.normal).setAlpha(0);
        }else{
            dificultad=0;
            findViewById(R.id.normal).setAlpha(0);
            findViewById(R.id.imposible).setAlpha(0);
        }
        partida=new Partida(dificultad);
        findViewById(R.id.unJugador).setEnabled(false);
        findViewById(R.id.facil).setEnabled(false);
        findViewById(R.id.normal).setEnabled(false);
        findViewById(R.id.imposible).setEnabled(false);
        findViewById(R.id.dosJugador).setEnabled(false);


    }

    private void rellenarTablaCasillas(){
        casillas=new int[9];
        casillas[0]=R.id.a1;
        casillas[1]=R.id.a2;
        casillas[2]=R.id.a3;
        casillas[0]=R.id.a1;
        casillas[1]=R.id.a2;
        casillas[2]=R.id.a3;
        casillas[0]=R.id.a1;
        casillas[1]=R.id.a2;
        casillas[2]=R.id.a3;
    }


}


