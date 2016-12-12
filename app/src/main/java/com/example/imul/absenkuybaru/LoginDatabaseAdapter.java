package com.example.imul.absenkuybaru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoginDatabaseAdapter extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    private static final String TABLE_ABSEN = "absen";

    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    private static final String KEY_NAMA = "nama";
    public static final String KEY_NRP = "NRP";
    public static final String KEY_KYU = "kyu";
    private static final String KEY_STATUS = "status";



    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String TABLE_LOGIN = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";

    private static final String CREATE_TABLE_ABSEN = "CREATE TABLE "
            + TABLE_ABSEN + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAMA + " TEXT,"
            + KEY_NRP+ " TEXT,"
            + KEY_KYU + " TEXT,"
            + KEY_STATUS + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ");";


    public  SQLiteDatabase db;

    public LoginDatabaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_ABSEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ABSEN);

        onCreate(db);
    }

    public  LoginDatabaseAdapter open() throws SQLException
    {
        db = getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String password) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public void createAbsen(Absen absen) {

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, absen.get_namaAng());
        values.put(KEY_NRP, absen.get_nrp());
        values.put(KEY_KYU, absen.get_kyu());
        values.put(KEY_STATUS, absen.get_telat());
        values.put(KEY_CREATED_AT, getDateTime());

        db.insert("absen", null, values);

        System.out.println(absen.get_namaAng());
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //////////METHOD INI ANUEN YA ELS AKU LUPA QUERYNYA
    public String getUsername(){

        final Cursor cursor = db.rawQuery("SELECT USERNAME FROM " + "LOGIN", null);
        String sum = "";
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    sum = cursor.getString(0);
                }
            } finally {
                cursor.close();
            }
        }

        return sum;
    }
    //////////METHOD INI ANUEN YA ELS AKU LUPA QUERYNYA

    public int deleteEntry(String UserName) {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String userName) {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String userName,String password) {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }

    public Cursor getDetails(String nrp) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM absen WHERE TRIM(nrp) like '"+nrp.trim()+"'", null);

        return c;
    }
    public Cursor hitungJumlah(String nrp) {
        String t = "tepat waktu";
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        Cursor d = db.rawQuery("SELECT status FROM absen WHERE TRIM(nrp) like '"+nrp.trim()+"' AND TRIM(status) like '"+t.trim()+"'", null);
        return d;
    }
}

