package com.example.imul.absenkuybaru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "login.db";
    public static final String TABLE_NAME = "login";
    public static final String COL_UNAME =  "Uname";
    public static final String COL_PASS =  "pass";
    public static final String COL_CONFPASS = "confpass";
    SQLiteDatabase db;
    static final String TABLE_CREATE = "create table login (name text not null, uname text not null, pass text not null);";


    public DatabaseHelper(Context context)
    {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertLogin (Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_UNAME, c.getUname);
        values.put(COL_PASS, c.getPass);
        values.put(COL_CONFPASS, c.getConfpass);

        db.insert(TABLE_NAME. null, values);
        db.close();
    }

    public String searchPass(String uname)
    {
        db =this.getWritableDatabase();
        String query = "select uname, pass from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";

        if (cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);


                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
