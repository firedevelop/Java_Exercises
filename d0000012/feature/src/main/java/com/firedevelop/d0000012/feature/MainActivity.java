package com.firedevelop.d0000012.feature;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.settings_id) {
            Toast.makeText(this, "Settings Cliked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.user_id) {
            Toast.makeText(this, "Users Cliked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.about_us_id) {
            Toast.makeText(this, "About Us Cliked", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.search_id){
            Toast.makeText(this,"Search Icon Cliked",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.cart_id){
            Toast.makeText(this, "Cart Clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.audiotrack){
            Toast.makeText(this, "audiotrack Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
