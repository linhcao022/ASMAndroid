package com.example.assigmentandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ListExpensesActivity extends AppCompatActivity {
    private SQLHandler db;
    private Cursor cursor;
    private SimpleCursorAdapter simpleCursorAdapter;
    private ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SQLHandler(this);
        lvList = findViewById(R.id.lvList);
        cursor = db.getAllCountries();
        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.row_item, cursor, new String[]{
                SQLHandler.ID, SQLHandler.NAME, SQLHandler.AMOUNT}, new int[]{R.id.tvId, R.id.tvName, R.id.tvAmount},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lvList.setAdapter(simpleCursorAdapter);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //reload data
        Cursor c = db.getAllCountries();
        simpleCursorAdapter.changeCursor(c);
        simpleCursorAdapter.notifyDataSetChanged();
        db.close();
    }
}
