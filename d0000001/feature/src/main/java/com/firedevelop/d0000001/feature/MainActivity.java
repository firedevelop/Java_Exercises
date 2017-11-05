package com.firedevelop.d0000001.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void info(View vista){
        Intent i=new Intent(this,info.class);
        startActivity(i);
    }
    public void salid(View vista){
        finish();
    }
    @Override public boolean onCreateOptionMenu(Menu mimenu){
     getMenuInflater().inflate(R.menu.menu,mimenu);
     return true;
    }
    @Override public boolean onOptionItemSelected(MenuItem opcion_menu){
        int id=opcion_menu.getItemId();
        if(id==R.id.config_menu){
            return true;
        }
        if(id==R.id.info_menu){
            if(id==R.id.info_menu){
                info(null);
            }
            return true;
        }
        return  super.onOptionsItemSelected(opcion_menu);
    }

}
