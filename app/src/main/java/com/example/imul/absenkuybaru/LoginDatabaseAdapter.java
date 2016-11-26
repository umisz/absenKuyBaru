package com.example.imul.absenkuybaru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDatabaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    static final int NAME_COLUMN = 1;

    //SQL statement untuk buat database baru
    static final String DATABASE_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";

    public SQLiteDatabase db;
    private final Context context;
    private DatabaseHelper dbHelper;

    public LoginDatabaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public LoginDatabaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String username, String password) {
        ContentValues newValues = new ContentValues();

        newValues.put("USERNAME", username);
        newValues.put("PASSWORD", password);

        db.insert("LOGIN", null, newValues);
    }

    public int deleteEntry(String username) {
        String where = "USERNAME=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{username});
        return numberOFEntriesDeleted;
    }

    public String getSingleEntry(String username) {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{username}, null, null, null);
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

    public void updateEntry(String username, String password) {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", username);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{username});
    }
}
