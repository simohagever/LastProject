package com.example.lastproject.repstory;

import android.content.Context;

import com.example.lastproject.MyDatabaseHelper;


public class repostory {

    Context context;
    User user;

    private MyDatabaseHelper myDatabaseHelper;



//    public repostory(Context context, View view, User user, MyDatabaseHelper myDatabaseHelper, Register register) {
//        this.context = context;
//        this.view = view;
//        this.user = user;
//        this.myDatabaseHelper = myDatabaseHelper;
//        this.register = register;
//    }

    public repostory(Context context)
    {
        this.context = context;
        myDatabaseHelper = new MyDatabaseHelper(this.context);
    }





    public MyDatabaseHelper getMyDatabaseHelper() {
        return myDatabaseHelper;
    }

//    public  void  getIsuserAlreadyRegister(){
//       this.myDatabaseHelper.isExistsRegister(this.user.getEmail(), this.user.getPassword(), this.user.getFirstName());
//   }



}
