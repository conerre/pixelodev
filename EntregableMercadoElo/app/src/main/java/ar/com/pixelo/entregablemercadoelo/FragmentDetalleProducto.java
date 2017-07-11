package ar.com.pixelo.entregablemercadoelo;


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
public class FragmentDetalleProducto extends Fragment {


    public static final String CLAVE_NOMBRE = "claveNombre";
    public static final String CLAVE_PRECIO = "clavePrecio";
    public static final String CLAVE_FOTO = "claveFoto";
    public static final String CLAVE_DETALLE = "claveDetalle";


    public FragmentDetalleProducto() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_detalle_producto, container, false);

        Bundle unBundle = getArguments();

        String nombre = unBundle.getString(CLAVE_NOMBRE);
        Integer precio = unBundle.getInt(CLAVE_PRECIO);
        Integer foto = unBundle.getInt(CLAVE_FOTO);
        String detalle = unBundle.getString(CLAVE_DETALLE);



        TextView nombreProducto  = (TextView)view.findViewById(R.id.detalleNombre);
        TextView precioProducto = (TextView) view.findViewById(R.id.detallePrecio);
        ImageView fotoProducto = (ImageView) view.findViewById(R.id.detalleImagen);
        TextView detalleProducto = (TextView) view.findViewById(R.id.detalleItem);

        nombreProducto.setText(nombre);
        precioProducto.setText("$ " + precio.toString());
        fotoProducto.setImageResource(foto);
        detalleProducto.setText(detalle);

        return view;
    }

}
