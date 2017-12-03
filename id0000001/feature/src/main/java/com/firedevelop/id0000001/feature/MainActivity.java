package com.firedevelop.id0000001.feature;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Telephony;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firedevelop.id0000014.feature.R;
public class MainActivity extends Activity{
    private int jugador;
    private int[] CASILLAS;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CASILLAS[0]=R.id.a1;
        CASILLAS[1]=R.id.a2;
        CASILLAS[2]=R.id.a3;
    }
    public void aJugar(View vista){
        ImageView imagen;
        for(int cadaCasilla:CASILLAS){
            imagen=(ImageView)findViewById(cadaCasilla);
            imagen.setImageResource(R.drawable.casilla);
        }
        jugador=1;
        if(vista.getId()==R.id.dosJugadores){
            jugador=2;
        }
        RadioGroup configDificultad=(RadioGroup)findViewById(R.id.configDificultad);
        int id=configDificultad.getCheckedRadioButtonId();
        int dificultad=0;
        if(vista.getId()==R.id.normal){
            dificultad=1;
        }else if(vista.getId()==R.id.imposible){
            dificultad=2;
        }
        partida=new Partida(View vista);
        ((Button)findViewById(R.id.unJugador)).setEnabled(false);
        ((Button)findViewById(R.id.dosJugadores)).setEnabled(false);
        ((RadioGroup)findViewById(R.id.configDificultad)).setAlpha(0);
    }
    public void toque(View vista){
        if(partida==null){
            return;
        }
        int casilla=0;
        for(int i=0;i<9;i++){
            if(CASILLAS[i]==vista.getId()){
                casilla=i;
                break;
            }
        }
        if(partida.comprueba_casilla(casilla)==false){
            return;
        }
        marca(casilla);
        resultado=partida.turno();

    }
    private void marca(int casilla){
        ImageView imagen;
        imagen=(ImageView)findViewById(CASILLAS[casilla]){
            if(partida.jugador==1){
                imagen.setImageResource(R.drawable.circulo);
            }else{
                imagen.setImageResource(R.drawable.aspa);
            }
        }
    }
    private void termina(int resultado){
        String mensaje;
        if(resultado==1) mensaje="Gc";
        else if(resultado==2)mensaje="Ga";
        else mensaje="Empate";
        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        partida=null;
        ((Button)findViewById(R.id.unJugador)).setEnabled(true);
        ((Button)findViewById(R.id.dosJugadores)).setEnabled(true);
        ((RadioGroup)findViewById(R.id.configDificultad)).setAlpha(0);
    }
}