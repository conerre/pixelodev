package ar.com.pixelo.entregablemercadoelo;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListView extends Fragment {


    public FragmentListView() {
        // Required empty public constructor
    }

    private NotificadorDeActivity notificadorDeActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_list_view, container, false);

        List<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(new Producto("Notebook Asus",8000,R.drawable.computadora_asus,"Zarpada compu para toda la flia"));
        listaDeProductos.add(new Producto("Camara Kodak",750,R.drawable.camara_kodak, "hermosa camara de fotos retro"));
        listaDeProductos.add(new Producto("Cuchillo",23,R.drawable.cuchillo_usado,"cuchillo calentito recien usado"));
        listaDeProductos.add(new Producto("Ford Fiesta",128000,R.drawable.ford_fiesta,"Joya nunca taxi"));
        listaDeProductos.add(new Producto("Libro Android",79,R.drawable.libro_android,"Con este libro sos un cra en Android"));
        listaDeProductos.add(new Producto("Libro Clean",90,R.drawable.libro_clean_code,"Limpia tu codigo con este book"));
        listaDeProductos.add(new Producto("Dvd Simpsons",80,R.drawable.simpsons_dvd,"La mejor serie animada inflatable en tu videoteca"));
        listaDeProductos.add(new Producto("Dvd South Park",90,R.drawable.south_park_dvd,"Matan a keny en todos los capitulos"));
        listaDeProductos.add(new Producto("DvD Volver al futuro",123,R.drawable.volver_al_futuro_dvd,"A donde vamos no necesitamos caminos. peliculon en DVD"));

        ListView listView = (ListView) view.findViewById(R.id.listViewProductos);
        Adapter adapter = new Adapter(listaDeProductos,getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Producto producto = (Producto) parent.getItemAtPosition(position);
                notificadorDeActivity.envioDeData(producto);
            }
        });



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorDeActivity = (NotificadorDeActivity) context;
    }

    public interface NotificadorDeActivity {
        public void envioDeData(Producto producto);
    }


}
