package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

   public DBHelper (@Nullable Context context) {
       super(context, "MyDB.db",null,1);
       SQLiteDatabase db = this.getWritableDatabase();
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE CUST_TABLE (CUSTOMER_ID INTEGER PRIMARY KEY, CUSTOMER_NAME TEXT, CUSTOMER_AGE INTEGER, ACTIVE_CUSTOMER TEXT)" ;
        db.execSQL(createTableStatement);
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
