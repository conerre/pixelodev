package ar.com.pixelo.entregablerestaurants;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import ar.com.pixelo.entregablerestaurants.Model.Receta;


public class RecetarioActivity extends AppCompatActivity implements FragmentRecetario.Notificable {


    public void cambiarFragment (Fragment unFragment){
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder, unFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetario);


        Fragment fragmentRecetario = new FragmentRecetario();
        cambiarFragment(fragmentRecetario);

    }

    @Override
    public void recipeTaken(Receta receta) {
        Fragment unFragment = new FragmentRecetaDetalle();


        Bundle unBundle = new Bundle();
        unBundle.putInt(FragmentRecetaDetalle.IMAGEN_RECETA, receta.getFoto());
        unBundle.putString(FragmentRecetaDetalle.TITULO_RECETA, receta.getTitulo());
        unBundle.putString(FragmentRecetaDetalle.INGREDIENTES_RECETA, receta.getIngredientes());
        unBundle.putString(FragmentRecetaDetalle.PROCEDIMIENTO_RECETA, receta.getProcedimiento());

unFragment.setArguments(unBundle);
       cambiarFragment(unFragment);
    }


}
