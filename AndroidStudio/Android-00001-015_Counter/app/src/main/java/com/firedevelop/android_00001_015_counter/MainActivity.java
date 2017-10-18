package com.firedevelop.android_00001_015_counter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=0;
    }
    public void incrementarContador(View vista){
        contador++;
        textoResultado();
    }
    public void decrementaContador(View vista){
        contador--;
        textoResultado();
    }
    public void resetearContador(View vista){
        contador=0;
        textoResultado();
    }
    public void textoResultado(){
        TextView textoResultado=(TextView)findViewById(R.id.contador);
        textoResultado.setText("Contador: " + contador);
    }



}