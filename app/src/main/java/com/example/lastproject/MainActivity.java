package com.example.lastproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lastproject.UI.Register.Register;
import com.example.lastproject.UI.homePage.HomePage;
import com.example.lastproject.repstory.repostory;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnlogin,btnMlogin,btnDelete;

    private repostory rp;
    private EditText Epass,Eemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnLog);
        btnMlogin = findViewById(R.id.MLogin);
        btnMlogin.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        rp = new repostory(this);
//        Epass.setClickable(true);


    }


    public void showCustomDialog(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.login,null);

        builder.setView(view);
        Eemail = view.findViewById(R.id.emailEdit);
        Epass = view.findViewById(R.id.passEdit);
        String email = Eemail.getText().toString();
        String pass = Epass.getText().toString();
        builder.setNeutralButton("login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(v == dialog){
//                    if(!(myDatabaseHelper.isExistsLogin(email,pass,2))){
//                         Eemail.setError("the email doesn't found");
//                        return;
//                    }
                    if(!(rp.getMyDatabaseHelper().isExistsLogin(email,pass,1))){
                        Epass.setError("the pass doesn't found");
                        return;
                    }

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);

                }

            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setPositiveButton("register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);


                //Toast.makeText(MainActivity.this, "כן סימו", Toast.LENGTH_SHORT).show();

            }
        });

        builder.setCancelable(false);
        builder.show();

    }

    @Override
    public void onClick(View v) {

        if(v == btnlogin){

            showCustomDialog(v);
        }

        if(v == btnMlogin){
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        }

        if(v==btnDelete){
            rp.getMyDatabaseHelper().deleteAllData();
        }



    }

}