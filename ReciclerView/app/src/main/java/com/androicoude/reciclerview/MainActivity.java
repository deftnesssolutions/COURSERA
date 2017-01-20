package com.androicoude.reciclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
       // GridLayoutManager glm = new GridLayoutManager(this,2);
        listaContactos.setLayoutManager(llm);
        inicializarListaContacto();
        inicializarAdaptador();

        /*ArrayList<String> nombresContacto  = new ArrayList<>();
        for (Contacto contacto:contactos)
        {
            nombresContacto.add(contacto.getNombre());
        }*/
        /*
        ListView lstContactos = (ListView)findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContacto));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.extra_nombre), contactos.get(position).getNombre());
                //intent.putExtra(getResources().getString(R.string.extra_nacimiento), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.extra_telefono), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.extra_email), contactos.get(position).getNombre());
                //intent.putExtra(getResources().getString(R.string.extra_descripcion), contactos.get(position).getNombre());
                startActivity(intent);
                finish();
            }
        });*/

    }
    public void inicializarListaContacto()
    {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Gustavo Ovelar","23345323","guove@gmail.com",R.drawable.mecanico) );
        contactos.add(new Contacto("Jeremias Santacruz","123456789","jeremias@gmail.com",R.drawable.icono) );
        contactos.add(new Contacto("Jose Leguizamon","234567123","jose@gmail.com",R.drawable.nave) );
        contactos.add(new Contacto("Roque Pereira","890567432","roque@gmail.com",R.drawable.paleta) );
    }

    public void inicializarAdaptador()
    {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }
}
