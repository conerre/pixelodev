package ar.com.pixelo.elo_json_entregable.Controller;

import android.content.Context;

import java.util.List;

import ar.com.pixelo.elo_json_entregable.Model.MOJO.DAOTracksDataBase;
import ar.com.pixelo.elo_json_entregable.Model.MOJO.DAOTracksInternet;
import ar.com.pixelo.elo_json_entregable.Model.MOJO.DataBaseHelper;
import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.Model.POJO.TrackContainer;
import ar.com.pixelo.elo_json_entregable.Utils.HTTPConnectionManager;
import ar.com.pixelo.elo_json_entregable.Utils.ResultListener;

/**
 * Created by Rodrigo on 20/6/2017.
 */

public class ControllerTrack {

    public void getListTrack( final ResultListener<List<Track>> viewListener,final Context context) {

        if (HTTPConnectionManager.isNetworkingOnline(context)) {
            ///pedir a la web
            DAOTracksInternet daoTracksInternet = new DAOTracksInternet();
            daoTracksInternet.getTrackListFromInternet(new ResultListener<List<Track>>() {
                @Override
                public void finish(List<Track> resultado) {
                    DAOTracksDataBase daoTracksDataBase = new DAOTracksDataBase(context);
                    daoTracksDataBase.addListTracks(resultado);

                    viewListener.finish(resultado);
                }
            });
        } else {
            DAOTracksDataBase daoTracksDataBase = new DAOTracksDataBase(context);
            List<Track> tracks = daoTracksDataBase.getListTrackInDataBase();
            viewListener.finish(tracks);


        }

    }
}
