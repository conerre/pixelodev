package ar.com.pixelo.elo_json_entregable.Model.MOJO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;

/**
 * Created by Rodrigo on 19/6/2017.
 */

public class DAOTracksDataBase extends DataBaseHelper {

    public static final String TABLE_NAME = "tracks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ALBUM_ID = "albumid";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_IMAGE_B = "imageB";

    public DAOTracksDataBase(Context context) {
        super(context);
    }

    public void addTrack (Track track) {
        if (!estaEnLaDB(track.getId())) {
            SQLiteDatabase database = getWritableDatabase();

            ContentValues row = new ContentValues();
            row.put(COLUMN_ID, track.getId());
            row.put(COLUMN_IMAGE, track.getMiniatura());
            row.put(COLUMN_ALBUM_ID, track.getAlbumId());
            row.put(COLUMN_TITLE, track.getTitle());
            row.put(COLUMN_IMAGE_B, track.getFotoGrande());

            database.insert(TABLE_NAME, null, row);
        }
    }

    public void addListTracks(List<Track>tracks){
        for (Track track: tracks){
            addTrack(track);
        }
    }

    private Boolean estaEnLaDB (Integer id){

        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT "+ COLUMN_ID +
                " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_ID + " = " + "'" + id + "'";


        Cursor cursor =  database.rawQuery(query, null);
        Boolean esta = cursor.moveToNext();
        cursor.close();
        database.close();

        return esta;
    }

    public List<Track> getListTrackInDataBase(){
        List<Track>tracks = new ArrayList<>();
        SQLiteDatabase database =  getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;


        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            Integer albumid = cursor.getInt(cursor.getColumnIndex(COLUMN_ALBUM_ID));
            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            String miniatura = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));
            String imageB = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_B));

            Track track = new Track(id, albumid, title, miniatura,imageB );
            tracks.add(track);
        }

        cursor.close();
        database.close();
        return tracks;

    }
}