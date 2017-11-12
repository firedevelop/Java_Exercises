package com.firedevelop.id0000018.feature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.firedevelop.id0000014.feature.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CASILLAS=new int[9];
        CASILLAS[0]=R.id.a1;
        CASILLAS[1]=R.id.a2;
        CASILLAS[2]=R.id.a3;
        CASILLAS[3]=R.id.b1;
        CASILLAS[4]=R.id.b2;
        CASILLAS[5]=R.id.b3;
        CASILLAS[6]=R.id.c1;
        CASILLAS[7]=R.id.c2;
        CASILLAS[8]=R.id.c3;
    }
    public void aJugar(View vista){
        ImageView imagen;
        for(int cadaCasilla:CASILLAS){
            imagen=(ImageView)findViewById((cadaCasilla));
            imagen.setImageResource(R.drawable.casilla);
        }
        jugadores=1;
        if(vista.getId()==R.id.dosJugador){
            jugadores=2;
        }
        RadioGroup configDificultad=(RadioGroup)findViewById(R.id.configDificultad);
        int id=configDificultad.getCheckedRadioButtonId();
        int dificultad=0;
        if(id==R.id.normal){
            dificultad=1;
        }else if(id==R.id.imposible){
            dificultad=2;
        }

        partida=new Partida(dificultad);
        ((Button)findViewById(R.id.unJugador)).setEnabled(false);
        ((RadioGroup)findViewById(R.id.configDificultad)).setAlpha(0);
        ((Button)findViewById(R.id.dosJugador)).setEnabled(false);

    }
    public void toque(View mivista){
        if(partida==null){
            return;
        }
        int casilla=0;
        for(int i=0;i<9;i++){
            if(CASILLAS[i]==mivista.getId()){
                casilla=i;
                break;
            }
        }
        marca(casilla);
    }
        private void marca(int casilla){
            ImageView imagen;
            imagen=(ImageView)findViewById(CASILLAS[casilla]);
            if(partida.jugador==1){
                imagen.setImageResource(R.drawable.circulo);
            }else{
                imagen.setImageResource(R.drawable.aspa);
            }
    }

    private int jugadores;
    private int[] CASILLAS;
    private Partida partida;

}
