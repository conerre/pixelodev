package ar.com.pixelo.entregablemercadoelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rodrigo on 21/5/2017.
 */

public class Adapter extends BaseAdapter{

    private List<Producto> listaDeProductos;
    private Context context;


    public Adapter(List<Producto> listaDeProductos, Context context) {
        this.listaDeProductos = listaDeProductos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDeProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDeProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detalle_producto_list_view, parent, false);
        Producto producto = listaDeProductos.get(position);


        ImageView imageView = (ImageView) view.findViewById(R.id.fotosprod);
        imageView.setImageResource(producto.getFoto());

        TextView textView = (TextView) view.findViewById(R.id.nombreprod);
        textView.setText(producto.getNombre());

        TextView textView1 = (TextView) view.findViewById(R.id.precioprod);
        textView1.setText("$"+ producto.getPrecio().toString());


        return view;
    }
}
