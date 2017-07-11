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

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new ListenerMenu());

    }

    private class ListenerMenu implements NavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            selectedMenuItem(item);
            return true;
        }
    }

    private void selectedMenuItem(MenuItem item) {
        // Aca implementamos el comportamiento según la opción seleccionada. (If/Else - Switch)

        final DrawerLayout drawer = (DrawerLayout)(findViewById(R.id.drawerLayout));

        switch (item.getItemId()){
            case R.id.menu_seccion_1:
                IrARestos();
                break;
            case R.id.menu_seccion_2:
               IrAAbout() ;
                break;
            case R.id.menu_seccion_3:
                IrARecetario();
                break;
        }
        drawer.closeDrawers();
    }

    private void IrAAbout() {
        Fragment unFragment = new FragmentAbout();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        fragmentTransaction.replace(R.id.contentFrame, unFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    private void IrARestos() {
        Intent unIntent = new Intent(this,RestoActivity.class);
        startActivity(unIntent);
    }

    private void IrARecetario(){
        Intent otroIntent = new Intent(this, RecetarioActivity.class);
        startActivity(otroIntent);
    }

}
