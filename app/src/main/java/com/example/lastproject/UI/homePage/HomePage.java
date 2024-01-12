package com.example.lastproject.UI.homePage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.repstory.repostory;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private TextView txName;
    private repostory rp;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        //case R.id.

        switch (item.getItemId()) {
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        txName = findViewById(R.id.name);
         //String n = myDatabaseHelper.
        back = findViewById(R.id.btnBack);
        back.setOnClickListener(this);




    }




    @Override
    public void onClick(View v) {

        if(v == back){
            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
        }
    }
}