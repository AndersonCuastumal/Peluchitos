package com.cc.ander.peluchitos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PelucheSQLiteHelper extends SQLiteOpenHelper {

    public PelucheSQLiteHelper(Context context,
                                 String name,
                                 SQLiteDatabase.CursorFactory factory,
                                 int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.sqlCreate);
            }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS peluche");
        db.execSQL(Utilidades.sqlCreate);
        onCreate(db);
    }
}
