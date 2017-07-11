package ar.com.pixelo.entregablerestaurants;

import android.content.Context;
import android.content.PeriodicSync;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ar.com.pixelo.entregablerestaurants.Model.Receta;
import ar.com.pixelo.entregablerestaurants.R;

/**
 * Created by Rodrigo on 7/6/2017.
 */

public class AdapterRecetario extends RecyclerView.Adapter implements View.OnClickListener {


    private List<Receta> recetas;
    private Context context;
    private View.OnClickListener listener;

    public AdapterRecetario(List<Receta> recetas, Context context) {
        this.recetas = recetas;
        this.context = context;

    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewDeLaCelda = layoutInflater.inflate(R.layout.recycler_receta_celda,parent,false);
        RecetasViewHolder recetasViewHolder = new RecetasViewHolder(viewDeLaCelda);

        viewDeLaCelda.setOnClickListener(this);
        return recetasViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    Receta unaReceta = recetas.get(position);
        RecetasViewHolder recetasViewHolder = (RecetasViewHolder)holder;
        recetasViewHolder.cargarReceta(unaReceta);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemCount()
    {
        return recetas.size();
    }

    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
           listener.onClick(v);
    }

    private class RecetasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textViewTitulo;


        public RecetasViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imagenRecetaCelda);
            textViewTitulo = (TextView) itemView.findViewById(R.id.tituloRecetaCelda);
        }

        public void cargarReceta (Receta recetaAMostrar){
            imageView.setImageResource(recetaAMostrar.getFoto());
            textViewTitulo.setText(recetaAMostrar.getTitulo());
        }
    }

}
