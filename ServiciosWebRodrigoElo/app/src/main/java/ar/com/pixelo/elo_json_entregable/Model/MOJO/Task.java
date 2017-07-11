package ar.com.pixelo.elo_json_entregable.Model.MOJO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.Model.POJO.TrackContainer;
import ar.com.pixelo.elo_json_entregable.Utils.DAOException;
import ar.com.pixelo.elo_json_entregable.Utils.HTTPConnectionManager;
import ar.com.pixelo.elo_json_entregable.Utils.ResultListener;

/**
 * Created by Rodrigo on 19/6/2017.
 */

public class Task extends AsyncTask<String, Void, List<Track>> {

    public ResultListener<List<Track>> controllerlistener;

    public Task(ResultListener<List<Track>> controllerlistener) {
        this.controllerlistener = controllerlistener;
    }

    @Override
    protected List<Track> doInBackground(String... params) {
        String url = params[0];
        List<Track> trackList = new ArrayList<>();

        HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;


        try {
            inputStream = httpConnectionManager.getRequestStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();
            TrackContainer trackContainer = gson.fromJson(bufferedReader, TrackContainer.class);
            trackList = trackContainer.getTracks();

        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            /////CLose Bufferreader y inputstream
            try {
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }

            httpConnectionManager.closeConnection();

        }

        return trackList;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        super.onPostExecute(tracks);
        controllerlistener.finish(tracks);
    }
}
