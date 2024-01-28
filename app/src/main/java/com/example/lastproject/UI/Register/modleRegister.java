package com.example.lastproject.UI.Register;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastproject.R;
import com.example.lastproject.repstory.User;
import com.example.lastproject.repstory.repostory;

public class modleRegister {
    private repostory rep;
    Context context;


    public modleRegister(Context context){
        this.context = context;
        rep = new repostory(this.context);
    }

    public boolean CheckUps(User user, EditText EIpassword)
    {
        if(user.getFirstName().toString().equals("")){
            //Toast.makeText(this, "fill first name", Toast.LENGTH_SHORT).show();

            Toast.makeText(context, "fill first name", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if(user.getFirstName().toString().length()<2){
//
//            Toast.makeText(context, "first name need to be at least two letters", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        for (int i = 0; i < user.getFirstName().length(); i++) {
//            if(!(user.getFirstName().toString().charAt(i)>='a' && user.getFirstName().toString().charAt(i)<='z' || user.getFirstName().toString().charAt(i)>='A' && user.getFirstName().toString().charAt(i)<='Z')){
//                  Toast.makeText(context, "first name need to be only with English letters", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }
//        if(user.getLastName().toString().equals("")){
//
//            Toast.makeText(context, "fill last name", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(user.getLastName().toString().length()<2){
//
//            Toast.makeText(context, "last name need to be at least two letters", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        for (int i = 0; i < user.getLastName().length(); i++) {
//            if(!(user.getLastName().toString().charAt(i)>='a' && user.getLastName().toString().charAt(i)<='z' || user.getLastName().toString().charAt(i)>='A' && user.getLastName().toString().charAt(i)<='Z')){
//
//                Toast.makeText(context, "last name need to be only with English letters", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }
//        if(user.getPassword().toString().equals("")){
//
//            Toast.makeText(context, "fill password", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if(user.getPassword().toString().length()<4){
//             Toast.makeText(context, "password need to be at least four letters", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if(EIpassword.getText().toString().equals("")){
//
//            Toast.makeText(context, "fill password confirmation", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if(!(user.getPassword().toString().equals(EIpassword.getText().toString()))){
//            Toast.makeText(context, "password confirmation need to be the same as the password", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if(user.getEmail().toString().equals("")){
//            Toast.makeText(context, "fill email confirmation", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
////            for (int i = 0; i < EFname1.length(); i++) {
////                if(!(EFname1.getText().toString().charAt(i)>='a' && EFname1.getText().toString().charAt(i)<='a' )){
////                    Toast.makeText(this, " email to be only with English letters or numbers", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////            }
//
//        for (int i = 0; i < user.getEmail().length(); i++) {
//            if(!(user.getEmail().toString().indexOf(".com") == user.getEmail().toString().length()-4 || user.getEmail().toString().indexOf(".co.") == user.getEmail().toString().length()-6))
//            {
//                Toast.makeText(context, "email format is invalid(.com)", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//            if(user.getEmail().toString().indexOf("@") ==-1  ){
//                Toast.makeText(context, "email format is invalid(-@)", Toast.LENGTH_SHORT).show();
//                return false;
//
//
//            }
//            if(!(user.getEmail().toString().indexOf("@") == user.getEmail().toString().lastIndexOf("@") )){
//                 Toast.makeText(context, "email format is invalid(2@)", Toast.LENGTH_SHORT).show();
//                return false;
//
//            }
//            if(!(user.getEmail().toString().indexOf(".") -  user.getEmail().toString().indexOf("@") >=3 )){
//                 Toast.makeText(context, "email format is invalid(@.)", Toast.LENGTH_SHORT).show();
//                return false;
//
//            }
//
//
//        }
//        String mail = user.getEmail().toString();
//        String pass = user.getPassword().toString();
//        String userName = user.getFirstName().toString();
//
//
//
//        if(rep.getMyDatabaseHelper().isExistsRegister(mail,pass,userName,3)){
//
//             Toast.makeText(context, "there is someone with this first name in the system already", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(rep.getMyDatabaseHelper().isExistsRegister(mail,pass,userName,2)){
//
//            Toast.makeText(context, "there is someone with this password in the system already", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(rep.getMyDatabaseHelper().isExistsRegister(mail,pass,userName,1)){
//
//             Toast.makeText(context, "there is someone with this email in the system already", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(user.getAddress().toString().equals("")){
//
//            Toast.makeText(context, "fill address", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        rep.getMyDatabaseHelper().addItem(user.getFirstName().toString(), user.getLastName().toString(), user.getPassword().toString(), user.getEmail().toString(),user.getAddress().toString());

        return true;
    }






























}
