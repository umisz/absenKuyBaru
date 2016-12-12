package com.example.imul.absenkuybaru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Imul on 03-Dec-16.
 */

/*
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="absen.db";
    private static final String TABLE_PRODUCTS="absen";
    private static final String TABLE_PRODUCTS2="login";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_USERN="usern";
    private static final String COLUMN_PASS="pass";
    private static final String COLUMN_NAMAANG="namaang";
    private static final String COLUMN_NRP="nrp";
    private static final String COLUMN_TELAT="telat";
    private static final String COLUMN_KYU="kyu";
    private static final String COLUMN_TGLABSEN="tglabsen";

    SQLiteDatabase db;

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_PRODUCTS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAMAANG + " TEXT," + COLUMN_NRP + " TEXT," +  COLUMN_KYU + " TEXT," + COLUMN_TELAT + " TEXT," + COLUMN_TGLABSEN + " TEXT" + ");";
        String query2 = " CREATE TABLE " + TABLE_PRODUCTS2 + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERN + " TEXT," + COLUMN_PASS + " TEXT" + ");";
        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(String namaAng, String nrp, String kyu, String telat, String tglAbsen) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAMAANG, namaAng);
        values.put(COLUMN_NRP, nrp);
        values.put(COLUMN_KYU, kyu);
        values.put(COLUMN_TELAT, telat);
        values.put(COLUMN_TGLABSEN, tglAbsen);

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    public void insertData(String usern, String pass) {
        SQLiteDatabase db1 = this.getReadableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(COLUMN_USERN, usern);
        values1.put(COLUMN_PASS, pass);

        db1.insert(TABLE_PRODUCTS2, null, values1);
        db1.close();
    }

    public void deleteProduct(String namaAng) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" DELETE FROM " + "TABLE_PRODUCTS" + " WHERE " + COLUMN_NAMAANG + "=\"" + namaAng + "\";" );
    }

    public String databaseToString() {

        SQLiteDatabase db = this.getWritableDatabase();

        String dbString="";

        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast()) {

            if(c.getString(c.getColumnIndex("namaang"))!=null) {

                dbString += c.getString(c.getColumnIndex("namaang"));
                dbString += "\n";

            }
            c.moveToNext();
        }

        db.close();
        return dbString;
    }

    public String getSinlgeEntry(String username) {

        Cursor cursor= db.query("login", null, " usern=?", new String[]{username}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("pass"));
        cursor.close();
        return password;
    }
}
*/
