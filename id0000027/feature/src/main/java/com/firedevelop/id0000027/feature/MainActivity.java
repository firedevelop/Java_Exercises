package com.firedevelop.id0000027.feature;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firedevelop.id0000014.feature.R;

public class MainActivity extends Activity {
    private int jugador;
    private int[] CASILLAS;
    private Partida partida;

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
        jugador =1;
        if(vista.getId()==R.id.dosJugadores){
            jugador =2;
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
        ((Button)findViewById(R.id.dosJugadores)).setEnabled(false);
        ((RadioGroup)findViewById(R.id.configDificultad)).setAlpha(0);


    }
    public void toque(View vista){
        if(partida==null){
            return;
        }
        /**
         *
         * aqui obtenemos la casilla que se ha pulsado
         * */
        int casilla=0;
        for(int i=0;i<9;i++){
            if(CASILLAS[i]==vista.getId()){
                casilla=i;
                break;
            }
        }
        /** IMPEDIR QUE LAS CASILLAS CON CIRCULOS SE PUEDAN VOLVER A MARCAR
        * le preguntamos si la casilla esta marcada
        * por que si lo está gracias al return se va a salir
        * del programa y no va a ir al siguiente metodo para marcar la casilla
        */
        if(partida.comprueba_casilla(casilla)==false){
            return;
        }

        marca(casilla);
        int resultado=partida.turno();
        if(resultado>0){
            termina(resultado);
            return;
        }
        casilla=partida.ia();
        /** IMPEDIR QUE LAS CASILLAS CON ASPAS SE PUEDAN VOLVER A MARCAR
         * Esto impedira que se puedan volver a marcar las casillas con aspas.
         *
         */
        while(partida.comprueba_casilla(casilla)!=true){
            casilla=partida.ia();
        }
        marca(casilla);
        resultado=partida.turno();
        if(resultado>0){
            termina(resultado);
        }
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
        // aunque se llame resultado no tiene nada que ver con "resultado" de arriba
        private void termina(int resultado){
            String mensaje;
            if(resultado==1) mensaje="Ganan los circulos";
            else if(resultado==2)mensaje="Ganan las aspas";
            else mensaje="Empate";
            Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            partida=null;
            ((Button)findViewById(R.id.unJugador)).setEnabled(true);
            ((Button)findViewById(R.id.dosJugadores)).setEnabled(true);
            ((RadioGroup)findViewById(R.id.configDificultad)).setAlpha(1);

        }
}
