package com.example.assigmentandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assigmentandroid.modal.Expenses;

import java.util.ArrayList;
import java.util.List;

public class SQLHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "expenses";

    // expenses table name
    private static final String TABLE_NAME= "money";

    // expenses Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MOUNT = "mount";
    private static final String KEY_CATEGORY = "categoryId";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_DATE = "dateSpend";

    public SQLHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_expenses_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MOUNT + " DOUBLE," + KEY_CATEGORY + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_DETAILS + " TEXT," + KEY_DATE + " DATE" + ")";
        db.execSQL(CREATE_expenses_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Adding new expenses
    void addExpenses(Expenses expenses) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, expenses.getId());
        values.put(KEY_NAME, expenses.getName());
        values.put(KEY_MOUNT, expenses.getMount()); 
        values.put(KEY_CATEGORY, expenses.getCategoryId());
        values.put(KEY_DESCRIPTION, expenses.getDescription());
        values.put(KEY_DETAILS, expenses.getDetails()); 
        values.put(KEY_DATE, expenses.getDateSpend()); 

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    // Getting single expenses
//    Expenses getexpenses(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
//                        KEY_NAME, KEY_MOUNT,KEY_CATEGORY, KEY_DESCRIPTION, KEY_DETAILS, KEY_DATE      }, KEY_ID + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        Expenses expenses = new Expenses(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getLong(2));
//        // return expenses
//        return expenses;
//    }

    // Getting All Countries
    public Cursor getAllCountries() {
        List<Expenses> expensesList = new ArrayList<Expenses>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

}
