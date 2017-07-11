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
public class FragmentDetail extends Fragment {

    public static final String TITLE_KEY = "clave titulo";
    public static final String IMAGE_KEY = "clave imagen";
    public static final String ID_KEY = "clave id";
    public static final String ALBUM_ID_KEY = "clave album id";
    public static final String IMAGE_KEY_B = "clave imagen grande";




    public FragmentDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_detail, container, false);
        Bundle bundle = getArguments();

        String title = bundle.getString(TITLE_KEY);
        String Image = bundle.getString(IMAGE_KEY);
        Integer idAlbum = bundle.getInt(ALBUM_ID_KEY);
        Integer id = bundle.getInt(ID_KEY);
        String imagenGrande = bundle.getString(IMAGE_KEY_B);

        Track unTrack = new Track(id, idAlbum, title, Image, imagenGrande);

        TextView textView = (TextView) view.findViewById(R.id.idDetail);
        textView.setText("Id: " +unTrack.getId().toString());

        TextView textView1 = (TextView) view.findViewById(R.id.idAlbumDetail);
        textView1.setText("Album Id: "+unTrack.getAlbumId().toString());

        TextView textView2 = (TextView) view.findViewById(R.id.titleDetail);
        textView2.setText(unTrack.getTitle());

        ImageView imageView = (ImageView) view.findViewById(R.id.cover600);
        Picasso.with(getContext()).load(imagenGrande)
                .placeholder(R.drawable.ic_cancel_black_600)
                .into(imageView);

        return view;
    }

}
