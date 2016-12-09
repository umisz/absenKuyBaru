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

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="absen.db";
    private static final String TABLE_PRODUCTS="absen";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAMAANG="namaang";
    private static final String COLUMN_KYU="kyu";
    private static final String COLUMN_TGLABSEN="tglabsen";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_PRODUCTS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAMAANG + " TEXT," + COLUMN_KYU + " TEXT," + COLUMN_TGLABSEN + " TEXT" + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Absen absen) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAMAANG, absen.get_namaAng());
        values.put(COLUMN_KYU, absen.get_kyu());
        values.put(COLUMN_TGLABSEN, absen.get_tglAbsen());

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    public void deleteProduct(String namaAng) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" DELETE FROM " + "TABLE_PRODUCTS" + " WHERE " + COLUMN_NAMAANG + "=\"" + namaAng + "\";" );
    }

    public String databaseToString() {

        SQLiteDatabase db = this.getWritableDatabase();

        String dbString="";

        String query = "SELECT * FROM" + TABLE_PRODUCTS + "WHERE 1";

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
}
