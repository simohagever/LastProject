package com.example.lastproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.health.connect.datatypes.ExerciseLap;
import android.media.effect.EffectFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button btnSendInformation,btnHomePage;
    private TextView btnBackToLogin;
    private EditText Epass,Eemail,Edate;

    private EditText EFname1,ELname,EPassword1,EIPassword,EEmail1,EAddress;
   private MyDatabaseHelper myDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnHomePage = findViewById(R.id.btnBackToHomepage);
        btnHomePage.setOnClickListener(this);
        btnBackToLogin = findViewById(R.id.btnGoBackToLogin);
        btnBackToLogin.setOnClickListener(this);
        btnSendInformation = findViewById(R.id.btnSendRegister);
        btnSendInformation.setOnClickListener(this);
        EFname1 = findViewById(R.id.firstname);
        ELname = findViewById(R.id.lastname);
        EPassword1 = findViewById(R.id.password);
        EIPassword = findViewById(R.id.Epassword);
        EEmail1 = findViewById(R.id.email);
        EAddress = findViewById(R.id.address);
        myDatabaseHelper = new MyDatabaseHelper(this);



    }



    public void showCustomDialog(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.login,null);

        builder.setView(view);

        builder.setNeutralButton("login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        Eemail = view.findViewById(R.id.emailEdit);
        Epass = view.findViewById(R.id.passEdit);
        builder.setCancelable(false);
        builder.show();

    }




    @Override
    public void onClick(View v) {


        if(v == btnSendInformation){

            if(EFname1.getText().toString().equals("")){
                //Toast.makeText(this, "fill first name", Toast.LENGTH_SHORT).show();
                EFname1.setError("fill first name");
                return;
            }
            if(EFname1.getText().toString().length()<2){
                 EFname1.setError("first name need to be at least two letters");
                return;
            }
            for (int i = 0; i < EFname1.length(); i++) {
                if(!(EFname1.getText().toString().charAt(i)>='a' && EFname1.getText().toString().charAt(i)<='z' || EFname1.getText().toString().charAt(i)>='A' && EFname1.getText().toString().charAt(i)<='Z')){
                    EFname1.setError("first name need to be only with English letters");
                    return;
                }
            }
            if(ELname.getText().toString().equals("")){
                ELname.setError("fill last name");
                return;
            }
            if(ELname.getText().toString().length()<2){
                ELname.setError("last name need to be at least two letters");
                return;
            }
            for (int i = 0; i < ELname.length(); i++) {
                if(!(ELname.getText().toString().charAt(i)>='a' && ELname.getText().toString().charAt(i)<='z' || EFname1.getText().toString().charAt(i)>='A' && EFname1.getText().toString().charAt(i)<='Z')){
                     ELname.setError("last name need to be only with English letters");
                    return;
                }
            }
            if(EPassword1.getText().toString().equals("")){
                EPassword1.setError("fill password");
                return;
            }

            if(EPassword1.getText().toString().length()<4){
                EPassword1.setError("password need to be at least four letters");
                return;
            }
            if(EIPassword.getText().toString().equals("")){
                EIPassword.setError("fill password confirmation");
                return;
            }

            if(!(EPassword1.getText().toString().equals(EIPassword.getText().toString()))){
                EIPassword.setError("password confirmation need to be the same as the password");
                return;
            }

            if(EEmail1.getText().toString().equals("")){
                EEmail1.setError("fill email confirmation");
                return;
            }

//            for (int i = 0; i < EFname1.length(); i++) {
//                if(!(EFname1.getText().toString().charAt(i)>='a' && EFname1.getText().toString().charAt(i)<='a' )){
//                    Toast.makeText(this, " email to be only with English letters or numbers", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
            for (int i = 0; i < EEmail1.length(); i++) {
                if(!(EEmail1.getText().toString().indexOf(".com") == EEmail1.getText().toString().length()-4 || EEmail1.getText().toString().indexOf(".co.") == EEmail1.getText().toString().length()-6))
                {
                    EEmail1.setError("email format is invalid(.com)");
                    return;
                }
                if(EEmail1.getText().toString().indexOf("@") ==-1  ){
                    EEmail1.setError("email format is invalid(-@)");
                     return;

                }
                if(!(EEmail1.getText().toString().indexOf("@") == EEmail1.getText().toString().lastIndexOf("@") )){
                    EEmail1.setError("email format is invalid(2@)");
                    return;

                }
                if(!(EEmail1.getText().toString().indexOf(".") -  EEmail1.getText().toString().indexOf("@") >=3 )){
                    EEmail1.setError("email format is invalid(@.)");
                    return;

                }


            }
            String mail = EEmail1.getText().toString();
            String pass = EPassword1.getText().toString();
            String userName = EFname1.getText().toString();



            if(myDatabaseHelper.isExistsRegister(mail,pass,userName,3)){

                EFname1.setError("there is someone with this first name in the system already");
                return;
            }
            if(myDatabaseHelper.isExistsRegister(mail,pass,userName,2)){

                EPassword1.setError("there is someone with this password in the system already");
                return;
            }
            if(myDatabaseHelper.isExistsRegister(mail,pass,userName,1)){

                EEmail1.setError("there is someone with this email in the system already");
                return;
            }
            if(EAddress.getText().toString().equals("")){
                EAddress.setError("fill address");
                 return;
            }



            myDatabaseHelper.addItem(EFname1.getText().toString(), ELname.getText().toString(), EPassword1.getText().toString(), EEmail1.getText().toString(),EAddress.getText().toString());
            Intent intent = new Intent(Register.this, HomePage.class);
            startActivity(intent);
        }

        if(v == btnBackToLogin){
            showCustomDialog(v);
        }

        if(v == btnHomePage){
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        }

    }
}