package ar.com.pixelo.entregablerestaurants;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.entregablerestaurants.Model.Resto;

public class RestoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);

        ////Lista de datos
        List<Resto> listaDeResto = new ArrayList<>();
        listaDeResto.add(new Resto("Central","Lima, Peru",R.drawable.central));
        listaDeResto.add(new Resto("Boragó","Santiago, Chile",R.drawable.borago));
        listaDeResto.add(new Resto("Astrid y Gaston","Lima, Peru",R.drawable.astridygaston));
        listaDeResto.add(new Resto("D.O.M","San Pablo, Brasil",R.drawable.dom));
        listaDeResto.add(new Resto("Maido","Lima, Peru",R.drawable.maido));
        listaDeResto.add(new Resto("Quintomil","Ciudad de México, México",R.drawable.quintonil));
        listaDeResto.add(new Resto("Tegui","Buenos Aires, Argentina",R.drawable.tegui));
        listaDeResto.add(new Resto("Maní","San Pablo, Brasil",R.drawable.mani));


        // FM
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        AdapterFragment adapterFragment = new AdapterFragment(fragmentManager, listaDeResto);
        viewPager.setAdapter(adapterFragment);

    }
}
