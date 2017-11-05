package com.firedevelop.a031activity.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu,mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.actionMenu_config){
            return true;
        }
        if(id==R.id.actionMenu_info){
            info(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
