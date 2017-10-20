package com.firedevelop.a018_counter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    public int contador;
    TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoResultado=(TextView)findViewById(R.id.contadorTexto);
        contador=0;

    }

    public void incrementaContador(View vista){
        contador++;
        textoResultado.setText("" +contador);
    }
    public void restaContador(View vista){
        contador--;
        if(contador<0){
            // aqui se hace un casting de negativos, y almacenamos dentro de negativos el checkbox
            CheckBox negativos=(CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }
        textoResultado.setText("" + contador);
    }
    public void reseteaContador(View vista){
        // aqui simplemente se identifica el el EditText "n_reseteo" y lo almacenamos en "numero_reset"
        EditText numero_reset=(EditText)findViewById(R.id.n_reseteo);
        try {
            contador = Integer.parseInt(numero_reset.getText().toString());
        }catch (Exception e){
            contador=0;
        }
        numero_reset.setText("");
        InputMethodManager miteclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(numero_reset.getWindowToken(),0);

        textoResultado.setText("" + contador);

    }

}
