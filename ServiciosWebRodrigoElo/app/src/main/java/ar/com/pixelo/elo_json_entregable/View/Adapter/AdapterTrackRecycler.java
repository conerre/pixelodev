package ar.com.pixelo.elo_json_entregable.View.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.R;

/**
 * Created by Rodrigo on 18/6/2017.
 */

public class AdapterTrackRecycler extends RecyclerView.Adapter implements View.OnClickListener  {

   private List<Track> tracks;
    private Context context;
    private View.OnClickListener listener;


    public AdapterTrackRecycler(List<Track> tracks, Context context) {
        this.tracks = tracks;
        this.context = context;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public void setTrackList(List<Track> trackList) {
        this.tracks = trackList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewDelTrack = layoutInflater.inflate(R.layout.fragment_track,parent,false);
        TracksViewHolder tracksViewHolder = new TracksViewHolder(viewDelTrack);

        viewDelTrack.setOnClickListener(this);
        return tracksViewHolder ;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Track untrack = tracks.get(position);
        TracksViewHolder tracksViewHolder =(TracksViewHolder)holder;
        tracksViewHolder.bindTrack(untrack);

    }


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    private class TracksViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewtitulo;
        private ImageView tapa;
        private TextView albumid;
        private TextView id;


        public TracksViewHolder(View itemView) {
            super(itemView);
            tapa = (ImageView) itemView.findViewById(R.id.track_image);
            textViewtitulo = (TextView)itemView.findViewById(R.id.track_titulo);
            albumid = (TextView)itemView.findViewById(R.id.album_id);
            id = (TextView)itemView.findViewById(R.id.track_id);

        }

        public void bindTrack (Track track){

            textViewtitulo.setText(track.getTitle());
            albumid.setText("Album Id: "+ track.getAlbumId().toString());
            id.setText("Id: "+track.getId().toString());
            Picasso.with(context).load(track.getMiniatura())
                    .placeholder(R.drawable.tattoyou)
                    .into(tapa);


        }


    }


}
