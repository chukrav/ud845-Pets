package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.pets.data.PetContract.*;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + PetEntry.TABLE_NAME
                +" ("+ PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                +PetEntry.COLUMN_PET_BREED + " TEXT,"
                +PetEntry.COLUMN_PET_GENDER+ " INTEGER NOT NULL,"
                +PetEntry.COLUMN_PET_WEGHT+ "INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DELETE FROM " + PetEntry.TABLE_NAME + ";";
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, oldVersion, newVersion);
    }
}
