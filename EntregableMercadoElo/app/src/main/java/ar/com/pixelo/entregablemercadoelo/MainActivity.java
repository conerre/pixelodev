package ar.com.pixelo.entregablemercadoelo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentListView.NotificadorDeActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo el fragment y lo pongo en el main
        Fragment unFragment = new FragmentListView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, unFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void envioDeData(Producto producto) {
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(FragmentDetalleProducto.CLAVE_NOMBRE, producto.getNombre());
        bundle.putInt(FragmentDetalleProducto.CLAVE_PRECIO,producto.getPrecio());
        bundle.putInt(FragmentDetalleProducto.CLAVE_FOTO,producto.getFoto());
        bundle.putString(FragmentDetalleProducto.CLAVE_DETALLE,producto.getDetalle());

        intent.putExtras(bundle);
        startActivity(intent);

    }
}
