package com.firedevelop.a1.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void info(View vista){
        Intent i=new Intent(this, info.class);
        startActivity(i);
    }
    public void salir(View vista){
        finish();
    }
     public boolean onOptionsItemSelected(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu,mimenu);
        return true;
    }
     public boolean onOptionItemSelected(MenuItem option_menu){
        int id=option_menu.getItemId();
        if(id==R.id.actionMenu_config){
            return true;
        }
        if(id==R.id.actionMenu_info){
            info(null);
            return true;
        }
        return super.onOptionsItemSelected(option_menu);
    }
}
