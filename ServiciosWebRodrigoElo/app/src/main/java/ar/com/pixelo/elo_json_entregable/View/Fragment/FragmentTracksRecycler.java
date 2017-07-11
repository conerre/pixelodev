package ar.com.pixelo.elo_json_entregable.View.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.elo_json_entregable.Controller.ControllerTrack;
import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.R;
import ar.com.pixelo.elo_json_entregable.Utils.ResultListener;
import ar.com.pixelo.elo_json_entregable.View.Adapter.AdapterTrackRecycler;
import ar.com.pixelo.elo_json_entregable.View.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTracksRecycler extends Fragment {

    private AdapterTrackRecycler adapterTrackRecycler;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ControllerTrack controllerTrack;


    private Notifier notifier;


    public FragmentTracksRecycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.recycler_tracks_fragment, container, false);
        List<Track> trackList = new ArrayList<>();

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_tracks);
        adapterTrackRecycler = new AdapterTrackRecycler(trackList, getContext());

        controllerTrack = new ControllerTrack();
        controllerTrack.getListTrack(new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {
                adapterTrackRecycler.setTrackList(resultado);
                adapterTrackRecycler.notifyDataSetChanged();
            }
        }, getContext());

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                List<Track> tracks = adapterTrackRecycler.getTracks();

                Track trackDetail = tracks.get(position);
                notifier.TakeAlbum(trackDetail);

            }
        };

        adapterTrackRecycler.setListener(listener);
        recyclerView.setAdapter(adapterTrackRecycler);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notifier = (Notifier)context;
    }
    public interface Notifier{
        public void TakeAlbum(Track track);

    }
}
