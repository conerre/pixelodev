package ar.com.pixelo.elo_json_entregable.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends Fragment {

    public static final String TITLE_KEY = "clave titulo";
   public static final String IMAGE_KEY = "clave imagen";
    public static final String ID_KEY = "clave id";
    public static final String ALBUM_ID_KEY = "clave album id";



    public static TrackFragment factoryTrack(String id, String albumid, String title, String miniatura) {
        TrackFragment trackFragment = new TrackFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ID_KEY, id);
        bundle.putString(ALBUM_ID_KEY, albumid);
        bundle.putString(TITLE_KEY, title);
        bundle.putString(IMAGE_KEY, miniatura);
        trackFragment.setArguments(bundle);

        return trackFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
//
        String miniatura = "error";

        Bundle bundle = getArguments();
        if (bundle != null){

            miniatura = bundle.getString(IMAGE_KEY);

        }

        View view =  inflater.inflate(R.layout.fragment_track, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.track_image);
        Picasso.with(getContext()).load(miniatura)
                .placeholder(R.drawable.ic_cancel_black_600)
                .into(imageView);

        TextView textView = (TextView) view.findViewById(R.id.track_titulo);


        return view;

    }

}
