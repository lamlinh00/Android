package com.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Store.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCategory = "Create table"+" Categories"+"("
                +"ID integer primary key autoincrement,"
                +"icon blob,"
                +"title text,"
                +"author text"
                +")";//#insert
        db.execSQL(tableCategory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+ "Categories");
        onCreate(db);
    }

    public boolean insert(byte[] icon, String author, String title){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("icon",icon);//
        values.put("title",title);
        values.put("author",author);
        long row = sqLiteDatabase.insert("Categories",null,values);
        return (row>0);
    }

    public boolean update(Context context, byte[] icon, String author, String title, int ID){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("icon",icon);//
        values.put("title",title);
        values.put("author",author);
        long row= sqLiteDatabase.update("Categories",values,"ID=?",
                new String[]{ID+""});
        return (row>0);
    }
    public boolean delete(Context context, byte[] icon, String author, String title, int ID) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long row = sqLiteDatabase.delete("Categories","ID=?",
                new String[]{ID+""});
        return (row>0);
    }

}
















