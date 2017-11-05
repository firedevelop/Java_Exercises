package com.firedevelop.a031activity.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }
    public void ejecutar_info(View vista){
        Intent i=new Intent(this, InfoClase.class);
        startActivity(i);
    }
    public void salirApp(View vista){
        finish();
    }

    @Override public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.configuracion){
            return true;
        }
        if(id==R.id.info){
            ejecutar_info(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}
