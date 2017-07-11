package ar.com.pixelo.entregablerestaurants;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.pixelo.entregablerestaurants.Model.Receta;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecetario extends Fragment {


    private List<Receta> recetaList;
    private AdapterRecetario adapterRecetario;
    private RecyclerView recyclerView;

    private Notificable notificable;

    public FragmentRecetario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        cargarRecetas();

        View view = inflater.inflate(R.layout.fragment_fragment_recetario, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerRecetario);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapterRecetario = new AdapterRecetario(recetaList, getContext());

            View.OnClickListener listenerMorfi = new View.OnClickListener() {
                public void onClick(View v) {
                    int posicion = recyclerView.getChildAdapterPosition(v);
                    List<Receta> listaRcetasRicas = adapterRecetario.getRecetas();

                    Receta recetaTocada = listaRcetasRicas.get(posicion);
                    notificable.recipeTaken(recetaTocada);
                }
            };


        adapterRecetario.setListener(listenerMorfi);
        recyclerView.setAdapter(adapterRecetario);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notificable = (Notificable) context;
    }




    public interface Notificable{
        public void recipeTaken(Receta receta);
    }

    private void cargarRecetas(){
        this.recetaList = new ArrayList();
        Receta ceviche = new Receta("Ceviche","200 gramos de pescado blanco (merluza, lenguado, corvina...),\n" +
                "Cilantro fresco o perejil fresco,\n" +
                "Una cebolla a ser posible morada,\n" +
                "Un aguacate,\n" +
                "4-6 limones grandes,\n" +
                "Pimienta molida, \n" +
                "Sal, \n" +
                "Un poco de ají o guindilla,\n" +
                "Un poco de ajo en polvo,\n" +
                "Cancha (maíz tostado))",R.drawable.secretos_cebiche_gaston,"Siempre que vayamos a preparar un ceviche hay que tener en cuenta que, como todo pescado que se va a servir crudo o poco cocinado, puede provocar Anisakiasis, que es una parasitosis provocada por las larvas del Anisakis, que se encuentran en el aparato digestivo de la mayoría de clases de pescado. Para evitarlo, debemos congelar el pescado antes de prepararlo, al menos unas 24 horas a una temperatura de -20ºC, o bien unas 15 horas al menos a -35ºC. La otra opción sería emplear pescado congelado para hacer el ceviche, así nos evitaríamos tener que hacerlo nosotros. Sabiendo esto, vamos ya con la receta. \n" +
                "Con esta receta vamos a preparar ceviche para 3-4 comensales, por lo que si necesitas más cantidad porque tengas más invitados a comer o porque quieras servir más cantidad, ajusta los ingredientes a tus necesidades. El pescado que se suele emplear de forma más habitual es pescado blanco, el que más te guste o tengas a mano, siendo los más recomendables la lubina, la merluza, la corvina o el bacalao, aunque se pueden preparar otros tipos de pescados azules, incluso langostinos. Puedes usar el pescado cortado en filetes o las piezas enteras, aunque la forma más cómoda a la hora de cortarlo es tenerlo en filetes o usar los lomos del mismo. \n" +
                "Una vez tengamos el pescado ya descongelado, lo vamos a cortar en forma de dados, que sean de entre uno y tres centímetros como máximo, o bien en tiras no demasiado grandes, como cada uno prefiera, aunque es mejor emplear la segunda opción si se usan filetes no demasiado gruesos. Una vez tengamos todo el pescado troceado de la forma elegida, lo echamos en un recipiente en el que podamos cubrirlo con el zumo de limón. Para ello cortamos exprimimos los limones, o limas o una mezcla de ambos si lo prefieres, colamos el zumo y lo vertemos sobre el pescado, de forma que quede bien cubierto por el mismo, para que se vaya marinando bien por todos lados.\n" +
                "Mientras dejamos que el pescado se marine con el ácido del limón unos 25-30 minutos, vamos a pelar la cebolla y la cortamos en tiras muy finas, lo más finas que podamos. Lavamos y picamos una buena cantidad de cilantro o perejil, lo que más os guste. Una vez que el pescado se haya marinado ese tiempo, verás que se ha vuelto de un color blanquecino, agregamos la cebolla picada y el cilantro o perejil. Añadimos pimienta negra molida, un poco de ajo en polvo y un toque de ají o guindilla, al gusto de cada uno, y removemos bien la mezcla. \n" +
                "Vamos a pelar el aguacate, quitándole la piel y el hueso del centro, y después lo vamos a cortar en trocitos de un tamaño similar al del pescado. Ya sólo nos quedaría servir el ceviche, para lo que lo servimos en las copas o recipientes individuales, y a las mismas les agregamos una pizca de sal al gusto, unos trozos de aguacate y algunos granos de maíz tostado, y de esta forma ya tenemos listo el ceviche de pescado para comerlo, mejor si lo servimos bien frío. Esperamos que os guste esta estupenda receta. " );

        Receta lomo = new Receta("Lomo Cordon Bleu","4 Filetes de Ternera grandes,\n" +
                "1 Pizca de Sal y pimienta negra recién molida,\n" +
                "4 Rodajas de Finas de Jamón cocido, \n" +
                "4 Rodajas de Finas de Queso gruyère, \n" +
                "6 Cucharadas soperas de Harina, \n" +
                "2 Unidades de Huevos, \n" +
                "8 Cucharadas soperas de Pan rallado, \n" +
                "80 Mililitros de Aceite para freír, \n" +
                "80 Gramos de Mantequilla",R.drawable.lomo_cordon, "Limpiar los filetesde ternera y colocarlos entre dos láminas de film transparente de cocina.\n" +
                "Aplanar ligeramente cada filete con ayuda de un rodillo. Frotarlos con sal y pimienta.\n" +
                "Paso 2 Colocar sobre la mitad de cada filete una loncha de jamón y otra de queso superpuestos.\n" +
                "Cubrir con la otra mitad del filete y fijar los extremos con ayuda de unos palillos, para evitar que se abran al manipularlos.\n" +
                "Paso 3 Poner en platos distintos, la harina, los huevos ligeramente batidos y el pan rallado.\n" +
                "Pasar cada filete relleno, primero por harina, luego por huevo y finalizamos con el pan.\n" +
                "Si se prefieren más gruesos, se vuelven a pasar por huevo primero y luego por pan rallado.\n" +
                "Calentar juntos el aceite y la mantequilla y freír cada filete cuatro minutos por cada lado.\n" +
                "Antes de servir, retirar los palillos." );

        Receta guiso = new Receta("Guiso de Lentejas","Lentejas secas, 500 g\n" +
                "Cebolla mediana, 1\n" +
                "Panceta ahumada, 150 g\n" +
                "Chorizo colorado seco, 1\n" +
                "Caldo, cantidad necesaria\n" +
                "Aceite de oliva, 3 cucharadas\n" +
                "Limón, 1\n" +
                "Perejil, 50 g\n" +
                "Sal y ají molido, a gusto",R.drawable.guiso,"– Hervir las lentejas en abundante agua con sal, hasta que estén a media cocción (unos 20 minutos).\n" +
                "– Cortar la panceta en bastones y dorar en una cacerola con un chorro de aceite de oliva.\n" +
                "– Agregar la cebolla picada, cocinar hasta que esté transparente.\n" +
                "– Incorporar el chorizo colorado cortado en rodajas finas.\n" +
                "– Agregar las lentejas previamente coladas y rápidamente incorporar caldo hasta cubrir.\n" +
                "– Condimentar con sal (si fuera necesario) y ají molido.\n" +
                "– Cocinar revolviendo de vez en cuando con cuchara de madera hasta que las lentejas estén tiernas y el guiso algo espeso.\n" +
                "– Cuidar que el guiso de lentejas no se seque durante la cocción, agregando caldo de ser necesario.\n" +
                "– Servir el guiso de lentejas acompañado de gajos de limón y espolvoreado con perejil picado.");

        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);
        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);
        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);
        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);
        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);
        recetaList.add(ceviche);
        recetaList.add(lomo);
        recetaList.add(guiso);


    }
}
