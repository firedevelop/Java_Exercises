package com.firedevelop.a021_counter_importante.feature;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView total;
    public int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total =(TextView)findViewById(R.id.total);
        contador=0;
        total.setText("" + contador);
        EventoTeclado teclado=new EventoTeclado();
        EditText num_reset=(EditText)findViewById(R.id.num_reset);
        num_reset.setOnEditorActionListener(teclado);

    }

    public void onSaveInstanceState(Bundle estado){
        estado.putInt("cuenta",contador);
        super.onSaveInstanceState(estado);
    }

    public void onRestoreInstanceState(Bundle estado){
        super.onRestoreInstanceState(estado);
        contador=estado.getInt("cuenta");
        total.setText(""+contador);
    }

    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if(i== EditorInfo.IME_ACTION_DONE){
                resetear(null);
            }
            return false;
        }
    }
    public void incrementar(View vista){
        contador++;
        total.setText("" +contador);
    }
    public void decrementar(View vista){
        contador--;
        if(contador<0){
            CheckBox negativos=(CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }
        total.setText("" + contador);
    }
    public void resetear(View vista){
        EditText num_reset=(EditText)findViewById(R.id.num_reset);
        try {
            contador = Integer.parseInt(num_reset.getText().toString());
        }catch (Exception e){
            contador=0;
        }
        num_reset.setText("");
        InputMethodManager miteclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(num_reset.getWindowToken(),0);
        total.setText("" + contador);
    }

}