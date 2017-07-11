package ar.com.pixelo.entregablerestaurants;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.pixelo.entregablerestaurants.Model.Receta;
import ar.com.pixelo.entregablerestaurants.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecetaDetalle extends Fragment {


    public static final String TITULO_RECETA = "titulo";
    public static final String  INGREDIENTES_RECETA = "ingredientes";
    public static final String IMAGEN_RECETA = "imagen";
    public static final String PROCEDIMIENTO_RECETA = "procedimiento";




    public FragmentRecetaDetalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_fragment_receta_detalle, container,false);
        Bundle bundle = getArguments();

    String titulo = bundle.getString(TITULO_RECETA);
        String ingredientes = bundle.getString(INGREDIENTES_RECETA);
        Integer imagen = bundle.getInt(IMAGEN_RECETA);
        String procedimiento =  bundle.getString(PROCEDIMIENTO_RECETA);

        Receta unaReceta = new Receta(titulo,ingredientes,imagen,procedimiento);

        ImageView imageView = (ImageView) view.findViewById(R.id.imagenRecetaDetalle);
        imageView.setImageResource(unaReceta.getFoto());

        TextView textViewNombre = (TextView) view.findViewById(R.id.tituloRecetaDetalle);
        textViewNombre.setText(unaReceta.getTitulo());

        TextView textViewIngreientes = (TextView) view.findViewById(R.id.ingredientesRecetaDetalle);
        textViewIngreientes.setText(unaReceta.getIngredientes());

        TextView textViewProcedimiento = (TextView) view.findViewById(R.id.procedimientoRecetaDetalle);
        textViewProcedimiento.setText(unaReceta.getProcedimiento());
        return view;


    }

}
