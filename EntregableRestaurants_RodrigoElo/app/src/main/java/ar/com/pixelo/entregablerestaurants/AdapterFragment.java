package ar.com.pixelo.entregablerestaurants;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.entregablerestaurants.Model.Resto;

/**
 * Created by Rodrigo on 3/6/2017.
 */

public class AdapterFragment extends FragmentStatePagerAdapter {


    private List<Fragment> listaDeFragments = new ArrayList<>(); //FRAGMENTS

    public AdapterFragment(FragmentManager fm, List<Resto> listaDeResto) {
        super(fm);
       for (Resto resto: listaDeResto){
           FragmentResto unFragmentResto = FragmentResto.restoMaker(resto.getName(),resto.getCity(),resto.getFoto());
           listaDeFragments.add(unFragmentResto);
       }
    }


    @Override
    public Fragment getItem(int position) {
        return this.listaDeFragments.get(position);
    }

    @Override
    public int getCount() {
        return this.listaDeFragments.size();
    }
}
