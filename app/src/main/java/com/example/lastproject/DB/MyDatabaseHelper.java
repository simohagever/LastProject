package com.example.lastproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FNAME = "FirstName";
    private static final String COLUMN_LNAME = "LastName";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_EMAIL = "Email";


    private static final String COLUMN_ADDRESS = "Address";


     public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FNAME + " TEXT, " +
                COLUMN_LNAME + " TEXT, " +
                COLUMN_PASSWORD+" TEXT, " +
                COLUMN_EMAIL+" TEXT, " +
                COLUMN_ADDRESS+" )";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    public boolean isExists(String email,String password) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT " + COLUMN_EMAIL + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = ? " + " AND " + COLUMN_PASSWORD + " = ? ";
//
//        Cursor cursor = db.rawQuery(query, new String[]{email, password});
//
////        if(cursor.getCount()>1){
////
////        }
//
//        boolean exists = cursor.getCount() == 1;
//
//
//        // Close the cursor and database to avoid memory leaks
//        cursor.close();
//        db.close();
//
//        return exists;
//    }
    public boolean isExistsRegister(String email,String password,String name, int which) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean isExistreg = false;
        String query = "SELECT " + COLUMN_EMAIL + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = ? ";
        String query3 = "SELECT " + COLUMN_FNAME + " FROM " + TABLE_NAME  + " WHERE " + COLUMN_FNAME + " = ? ";
        String query2 = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PASSWORD + " = ? ";

        switch(which)
        {
            case 1:
            {
                Cursor cursor = db.rawQuery(query, new String[]{email});
                isExistreg = cursor.getCount() == 1;
                cursor.close();
                return isExistreg;
            }
            case 2:
            {
                Cursor cursor = db.rawQuery(query2, new String[]{password});
                isExistreg = cursor.getCount() == 1;
                cursor.close();
                return isExistreg;
            }
            case 3:
            {
                Cursor cursor = db.rawQuery(query3, new String[]{name});
                isExistreg = cursor.getCount() == 1;
                cursor.close();
                return isExistreg;
            }

        }

        // Close the cursor and database to avoid memory leaks
        db.close();

        return isExistreg;
    }

    public boolean isExistsLogin(String email,String password, int which) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean isExistreg = false;
        String query = "SELECT " + COLUMN_EMAIL + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ? ";
        String query2 = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COLUMN_PASSWORD + " = ? AND " + COLUMN_EMAIL + " = ?";

        switch(which)
        {
            case 1:
            {
                Cursor cursor = db.rawQuery(query, new String[]{email,password});
                isExistreg = cursor.getCount() == 1;
                cursor.close();
                return isExistreg;
            }
            case 2:
            {
                Cursor cursor = db.rawQuery(query2, new String[]{password,email});
                isExistreg = cursor.getCount() == 1;
                cursor.close();
                return isExistreg;
            }


        }

        // Close the cursor and database to avoid memory leaks
        db.close();

        return isExistreg;
    }
    public void addItem(String Fname, String Lname,String Password,String Email, String Address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FNAME, Fname);
        cv.put(COLUMN_LNAME, Lname);
        cv.put(COLUMN_PASSWORD, Password);
        cv.put(COLUMN_EMAIL, Email);
        cv.put(COLUMN_ADDRESS, Address);


        long result = db.insert(TABLE_NAME,null, cv);
        //Log.d("DB",Product);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String Fname, String Lname,String Password,String Email, String Address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FNAME, Fname);
        cv.put(COLUMN_LNAME, Lname);
        cv.put(COLUMN_PASSWORD, Password);
        cv.put(COLUMN_EMAIL, Email);
        cv.put(COLUMN_ADDRESS, Address);


        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        Toast.makeText(context, "Deleted all data", Toast.LENGTH_SHORT).show();
    }

}
