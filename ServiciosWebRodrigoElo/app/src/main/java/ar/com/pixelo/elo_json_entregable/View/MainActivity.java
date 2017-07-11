package ar.com.pixelo.elo_json_entregable.View;

import android.speech.RecognitionService;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ar.com.pixelo.elo_json_entregable.Model.POJO.Track;
import ar.com.pixelo.elo_json_entregable.R;
import ar.com.pixelo.elo_json_entregable.View.Fragment.FragmentDetail;
import ar.com.pixelo.elo_json_entregable.View.Fragment.FragmentTracksRecycler;
import ar.com.pixelo.elo_json_entregable.View.Fragment.TrackFragment;


public class MainActivity extends AppCompatActivity implements FragmentTracksRecycler.Notifier {



public void changeFragment (Fragment unFragment){
    FragmentManager fragmentManager =  getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, unFragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragmentTracksRecycler = new FragmentTracksRecycler();
        changeFragment(fragmentTracksRecycler);


    }

    @Override
    public void TakeAlbum(Track track) {
        Fragment fragment = new FragmentDetail();

        Bundle bundle = new Bundle();

        bundle.putInt(FragmentDetail.ID_KEY,track.getId());
        bundle.putInt(FragmentDetail.ALBUM_ID_KEY,track.getAlbumId());
        bundle.putString(FragmentDetail.TITLE_KEY,track.getTitle());
        bundle.putString(FragmentDetail.IMAGE_KEY_B,track.getFotoGrande());

        fragment.setArguments(bundle);
        changeFragment(fragment);

    }
}