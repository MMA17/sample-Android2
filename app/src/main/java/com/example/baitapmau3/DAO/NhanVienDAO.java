package com.example.baitapmau3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.baitapmau3.Class.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "database.db";
    public NhanVienDAO(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void create() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS nhanvien (id integer PRIMARY KEY AUTOINCREMENT, ten text, namsinh text, que text, trinhdo text)");
    }

    public List<NhanVien> getALlNhanVien() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<NhanVien> res = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM nhanvien", null);
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            NhanVien nv = new NhanVien(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),c.getString(4));
            res.add(nv);
            c.moveToNext();
        }
        return res;
    }

    public boolean addNhanVien(NhanVien nv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ten", nv.getTen());
        cv.put("namsinh", nv.getNamsinh());
        cv.put("que", nv.getQue());
        cv.put("trinhdo", nv.getTrinhdo());
        long res = db.insert("nhanvien", null, cv);
        if (res == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
