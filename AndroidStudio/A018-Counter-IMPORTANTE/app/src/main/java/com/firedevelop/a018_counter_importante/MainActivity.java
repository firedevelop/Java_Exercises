package com.firedevelop.a018_counter_importante;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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

        EventoTeclado teclado=new EventoTeclado();
        EditText num_reset=(EditText)findViewById(R.id.num_reset);
        num_reset.setOnEditorActionListener(teclado);

    }
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            //IME significa Input Managment Editor, o sea en nuestro caso el teclado. Y le decimos que ya hemos terminado de usarlo, es decir ..._DONE
            if(i==EditorInfo.IME_ACTION_DONE){
                //llamamos a resetear, pero como nos obliga la API a pasarle un parametro y nosotro no queremos pasarle nada, usaremos null y funcionara
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
            // aqui se hace un casting de negativos, y almacenamos dentro de negativos el checkbox
            CheckBox negativos=(CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }
        total.setText("" + contador);
    }
    public void resetear(View vista){
        // aqui simplemente se identifica el el EditText "n_reseteo" y lo almacenamos en "numero_reset"
        EditText num_reset=(EditText)findViewById(R.id.num_reset);
        try {
            contador = Integer.parseInt(num_reset.getText().toString());
            // si no capturamos esta excepcion, cuando un usuario pulse directamente el boton reset si hacer clic previamente en el teclado para insertar un numero, el programa se caera, por no le estas pasando un cero, sino un cero virtual, ya que este EditText esta configurado con la propiedad de EditText hint, es decir que muestra un cero virtual que no es un int solo de uso visual para que no quede en blanco el EditText
        }catch (Exception e){
            contador=0;
        }
        //aqui lo que hacemos es volver a establecer en 0 el EditText de los numeros negativos. Si no lo hacemos se quedaría fijo el ultimo numero elegido por teclado
        num_reset.setText("");
        //aqui le decimos que cual es el metodo de entrada que estamos usando y que lo meta almacena en "miteclado"
        InputMethodManager miteclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        // aqui le decimos que oculte el metodo de entrada o sea miteclado
        miteclado.hideSoftInputFromWindow(num_reset.getWindowToken(),0);
        total.setText("" + contador);
    }

}