package ar.com.pixelo.elo_json_entregable.Model.MOJO;

import java.util.List;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.Utils.ResultListener;

/**
 * Created by Rodrigo on 19/6/2017.
 */

public class DAOTracksInternet {
    public void getTrackListFromInternet (ResultListener<List<Track>> controllerlistener){
        Task task = new Task(controllerlistener);
        task.execute("https://api.myjson.com/bins/zwe9v");

    }
}
