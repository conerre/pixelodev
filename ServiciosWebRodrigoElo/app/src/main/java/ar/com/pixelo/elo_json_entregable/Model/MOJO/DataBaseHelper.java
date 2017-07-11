package ar.com.pixelo.elo_json_entregable.Model.MOJO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rodrigo on 19/6/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="tracks_db";
    public static final Integer DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query ="CREATE TABLE " + DAOTracksDataBase.TABLE_NAME + " (" +
            DAOTracksDataBase.COLUMN_ID + " TEXT PRIMARY KEY, " +
            DAOTracksDataBase.COLUMN_ALBUM_ID + " TEXT NOT NULL, " +
            DAOTracksDataBase.COLUMN_IMAGE + " TEXT NOT NULL, " +
            DAOTracksDataBase.COLUMN_IMAGE_B + " TEXT NOT NULL, " +
            DAOTracksDataBase.COLUMN_TITLE + " TEXT NOT NULL);";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
