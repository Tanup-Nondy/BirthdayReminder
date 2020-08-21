package com.androidlime.birthdayreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tanup on 7/4/2017.
 */
public class DataBase extends SQLiteOpenHelper{
    private static final String DName="Birthday";
    private static final String Table="remind";
    private static final String Id="id";
    private static final String Name="name";
    private static final String Day="day";
    public DataBase(Context context) {
        super(context, DName,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE "+Table+"( "+Id+" INTEGER PRIMARY KEY, "+Name+" TEXT, "+Day+" TEXT "+")";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    void Insert(String name,String day){
        SQLiteDatabase in=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Name,name);
        cv.put(Day,day);
        in.insert(Table,null,cv);
        in.close();
    }
    int Update(int id,String day){
        SQLiteDatabase up=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Day,day);
        return up.update(Table,cv,Id+" =? ",new String[]{id+""});
    }
    int Delete(String day){
        SQLiteDatabase del=this.getWritableDatabase();
        return del.delete(Table,Day+" =? ",new String[]{day+""});
    }
    String[] show(){
        SQLiteDatabase sw=this.getReadableDatabase();

        String query="SELECT * FROM "+Table;
        Cursor c=sw.rawQuery(query,null);
        String[] s=new String[c.getCount()];
        c.moveToFirst();
        if(c.moveToFirst()){
            int count=0;
            do{
                s[count]=c.getString(c.getColumnIndex(Name + "")) + "\nBirthday : " +
                        c.getString(c.getColumnIndex(Day + ""))+"\n";
                count++;
            }while(c.moveToNext());
        }
        return s;
    }
    String getDay(int id){
        SQLiteDatabase bd=this.getReadableDatabase();
        String query="SELECT "+Day+" FROM "+Table+" WHERE "+Id+"="+id;
        Cursor c=bd.rawQuery(query,null);
        c.moveToFirst();
        String day="";
        if(c.moveToFirst()){
            day=c.getString(c.getColumnIndex(Day+""));
        }
        return day;
    }
}
