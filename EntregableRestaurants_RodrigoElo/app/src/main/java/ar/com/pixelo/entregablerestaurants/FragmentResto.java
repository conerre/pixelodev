package ar.com.pixelo.entregablerestaurants;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentResto extends Fragment {

    private String name;
    private String city;
    private Integer pic;

    public static final String CLAVE_NOMBRE = "claveNombre";
    public static final String CLAVE_CIUDAD = "claveCiudad";
    public static final String CLAVE_FOTO = "claveFoto";

    public static FragmentResto restoMaker(String name, String city, Integer pic) {
        Bundle unBundle = new Bundle();
        unBundle.putString(CLAVE_NOMBRE, name);
        unBundle.putString(CLAVE_CIUDAD, city);
        unBundle.putInt(CLAVE_FOTO, pic);
        FragmentResto fragmentResto = new FragmentResto();
        fragmentResto.setArguments(unBundle);
        return fragmentResto;

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_resto, container, false);

        Bundle unBundle = getArguments();
        name = unBundle.getString(CLAVE_NOMBRE);
        city = unBundle.getString(CLAVE_CIUDAD);
        pic = unBundle.getInt(CLAVE_FOTO);

        // Inflate the layout for this fragment

        ImageView lugar = (ImageView) view.findViewById(R.id.fotoConteiner);
        lugar.setImageResource(pic);
        TextView marca = (TextView)view.findViewById(R.id.restoName);
        marca.setText(name);
        TextView ciudad = (TextView)view.findViewById(R.id.restoCity);
        ciudad.setText(city);

        return view;
    }


}
