package com.project.shweta.shwetakherapractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String first_name, String last_name,String dob) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.FIRST_NAME, first_name);
        contentValue.put(DatabaseHelper.LAST_NAME, last_name);
        contentValue.put(DatabaseHelper.DOB, dob);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public List<Profile> getAllProfiles() {
        List<Profile> profileList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + dbHelper.TABLE_NAME;

        database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Profile profile = new Profile();
                profile.setFirstName(cursor.getString(cursor.getColumnIndex(dbHelper.FIRST_NAME)));
                profile.setLastName(cursor.getString(cursor.getColumnIndex(dbHelper.LAST_NAME)));
                profile.setDOB(cursor.getString(cursor.getColumnIndex(dbHelper.DOB)));

                profileList.add(profile);
            } while (cursor.moveToNext());
        }

        // close db connection
        database.close();

        // return notes list
        return profileList;
    }

    public int update(String first_name, String last_name,String dob) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.FIRST_NAME, first_name);
        contentValues.put(DatabaseHelper.LAST_NAME, last_name);
        contentValues.put(DatabaseHelper.DOB,dob);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.FIRST_NAME + " = " + first_name, null);
        return i;
    }

    public void delete(String first_name) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.FIRST_NAME + "=" + first_name, null);
    }

}
