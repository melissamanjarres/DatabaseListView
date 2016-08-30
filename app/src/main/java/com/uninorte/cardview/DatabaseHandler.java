package com.uninorte.cardview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 30/08/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final  int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "theDataBase";

    public static final String TABLE = "theTable";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_AGE = "age";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE + "(" + KEY_ID + " integer primary key, "
                + KEY_NAME + "text, " + KEY_LASTNAME + " text, " + KEY_AGE + "  text)";

        if(db.isOpen()){
            db.execSQL(CREATE_TABLE);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE);
    }

    public SQLiteDatabase getWriteDatabase(){
        return super.getWritableDatabase();
    }

}
