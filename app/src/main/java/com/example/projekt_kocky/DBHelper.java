package com.example.projekt_kocky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBTAMZ2.db";
    public static final String ITEM_COLUMN_PLAYER1 = "player1";
    public static final String ITEM_COLUMN_PLAYER2 = "player2";
    public static final String ITEM_COLUMN_SCORE1 = "score1";
    public static final String ITEM_COLUMN_SCORE2 = "score2";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE history " + "(id INTEGER PRIMARY KEY, player1 STRING, player2 STRING, score1 INTEGER, score2 INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS history");
        onCreate(db);
    }

    public boolean insertItem(String player1, String player2, Integer score1, Integer score2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_COLUMN_PLAYER1, player1);
        contentValues.put(ITEM_COLUMN_PLAYER2, player2);
        contentValues.put(ITEM_COLUMN_SCORE1, score1);
        contentValues.put(ITEM_COLUMN_SCORE2, score2);
        long insertedId = db.insert("history", null, contentValues);
        if (insertedId == -1) return false;
        return true;
    }

    public ArrayList<String> getItemList() {

        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from history", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            String player1 = res.getString(res.getColumnIndex(ITEM_COLUMN_PLAYER1));
            String player2 = res.getString(res.getColumnIndex(ITEM_COLUMN_PLAYER2));
            String score1 = res.getString(res.getColumnIndex(ITEM_COLUMN_SCORE1));
            String score2 = res.getString(res.getColumnIndex(ITEM_COLUMN_SCORE2));
            arrayList.add(player1 + " --> " + score1 + "  :  " + score2 + " <--  " + player2);
            res.moveToNext();
        }
        return arrayList;
    }


    public Integer removeAll() {

        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor res = dbr.rawQuery("select * from history", null);
        int count = res.getCount();

        String delete = "DELETE from history WHERE id > 0";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(delete);

        return count;
    }
}
