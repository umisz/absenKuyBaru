package com.example.imul.absenkuybaru;

/*
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Imul on 11-Dec-16.
 */

/*
public class DBAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_UNAME = "uname";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_NRP = "NRP";
    public static final String KEY_KYU = "kyu";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TGL = "tgl";
    private static final String TAG = "ABSENDB";
    private static final String DATABASE_NAME1 = "absen";
    private static final String DATABASE_TABLE = "login";
    private static final String DATABASE_TABLE1 = "data_absen";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table login (_id integer primary key autoincrement, uname text not null, password text not null);";
    private static final String DATABASE_CREATE1 =
            "create table absen (_id integer primary key autoincrement, nama text not null, NRP text not null, kyu text not null, status text not null, tgl text not null);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME1, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            long x;
            db.execSQL(DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS PESITMSESTUDENT");
            onCreate(db);

        }
    }
    //---opens the database---
    public DBAdapter open() throws SQLException {
        Log.i(TAG, "opening the database");
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() {
        Log.i(TAG, "closing the database");
        DBHelper.close();
    }

    public void insertEntry(String userName,String password) {

        Log.i(TAG, "MEMASUKKAN ADMIN BARU");
        ContentValues newValues = new ContentValues();

        newValues.put(KEY_UNAME, userName);
        newValues.put(KEY_PASSWORD,password);

        db.insert(DATABASE_TABLE, null, newValues);
    }

    public void insertAbsen(String nama, String nrp, String kyu, String status, String tgl) {

        Log.i(TAG, "MEMASUKKAN ABSEN BARU");

        ContentValues newValues = new ContentValues();

        newValues.put(KEY_NAMA, nama);
        newValues.put(KEY_NRP, nrp);
        newValues.put(KEY_KYU, kyu);
        newValues.put(KEY_STATUS, status);
        newValues.put(KEY_TGL, tgl);

        db.insert(DATABASE_TABLE1, null, newValues);
    }

    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query(DATABASE_TABLE1, null, " uname=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;
    }
}
*/

