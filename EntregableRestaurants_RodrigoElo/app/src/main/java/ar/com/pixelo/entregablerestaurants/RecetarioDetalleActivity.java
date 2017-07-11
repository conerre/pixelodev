package ar.com.pixelo.entregablerestaurants;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ar.com.pixelo.entregablerestaurants.Model.Receta;
import ar.com.pixelo.entregablerestaurants.R;

public class RecetarioDetalleActivity extends AppCompatActivity implements FragmentRecetario.Notificable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetario_detalle);

        Intent unIntent = getIntent();

        Bundle bundle = unIntent.getExtras();

        FragmentRecetaDetalle fragmentRecetaDetalle = new FragmentRecetaDetalle();
        fragmentRecetaDetalle.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.detalleContainer, fragmentRecetaDetalle);
        fragmentTransaction.commit();
    }

    @Override
    public void recipeTaken(Receta receta) {

        Intent unIntent = new Intent (this, RecetarioDetalleActivity.class);

        Bundle unBundle = new Bundle();
        unBundle.putInt(FragmentRecetaDetalle.IMAGEN_RECETA, receta.getFoto());
        unBundle.putString(FragmentRecetaDetalle.TITULO_RECETA, receta.getTitulo());
        unBundle.putString(FragmentRecetaDetalle.INGREDIENTES_RECETA, receta.getIngredientes());
        unBundle.putString(FragmentRecetaDetalle.PROCEDIMIENTO_RECETA, receta.getProcedimiento());

        unIntent.putExtras(unBundle);

        startActivity(unIntent);



    }
}
