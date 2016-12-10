package com.example.imul.absenkuybaru;

/**
 * Created by ginanjarpr on 28/11/2016.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDatabaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    private static final String TABLE_PRODUCTS="absen";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAMAANG="namaang";
    private static final String COLUMN_NRP="nrp";
    private static final String COLUMN_TELAT="telat";
    private static final String COLUMN_KYU="kyu";
    private static final String COLUMN_TGLABSEN="tglabsen";

    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_PRODUCTS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAMAANG + " TEXT," + COLUMN_NRP + " TEXT," + COLUMN_KYU + " TEXT," + COLUMN_TELAT + " TEXT," + COLUMN_TGLABSEN + " TEXT" + ");";
        db.execSQL(query);
    }

    // Variable to hold the database instance
    public  SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  LoginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
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

    public void insertEntry(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
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

    public int deleteEntry(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String userName)
    {
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
    public void  updateEntry(String userName,String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
    public void addProduct(String namaAng, String nrp, String kyu, String telat, String tglAbsen) {

        db=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAMAANG, namaAng);
        values.put(COLUMN_NRP, nrp);
        values.put(COLUMN_KYU, kyu);
        values.put(COLUMN_TELAT, telat);
        values.put(COLUMN_TGLABSEN, tglAbsen);

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }
}
