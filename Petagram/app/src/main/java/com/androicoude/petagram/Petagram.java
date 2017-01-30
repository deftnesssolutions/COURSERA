package com.androicoude.petagram;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Petagram extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotaHardcodeadas  = new ArrayList<Mascota>();
    private RecyclerView listaMascotas;
    public String raiting ="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petagram);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.drawable.dog_footprint_52);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        Intent extras = getIntent();
        if(extras !=null)
        {
            Bundle recibirExtras = extras.getExtras();
            if(recibirExtras !=null)
            {
                mascotas = recibirExtras.getParcelableArrayList("mascotas");
            }
        }

        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorito:
                //action(R.string.action_favorito);
                llamarFavoritos();
                return true;
            case R.id.action_edit:
                action(R.string.action_edit);
                return true;
            case R.id.action_settings:
                action(R.string.action_settings);
                return true;
            case R.id.action_help:
                action(R.string.action_help);
                return true;
            case R.id.action_about:
                action(R.string.action_about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void action(int resid) {
        //Toast.makeText(this, getText(resid), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Proximos a ser implementado", Toast.LENGTH_SHORT).show();
    }
    public void inicializarListaMascota()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.amigos,"Brothers",raiting));
        mascotas.add(new Mascota(R.drawable.labrador,"Labrador",raiting));
        mascotas.add(new Mascota(R.drawable.pastor,"Pastor",raiting));
        mascotas.add(new Mascota(R.drawable.viralata,"Vira Lata",raiting));
        mascotas.add(new Mascota(R.drawable.gatito,"Tom",raiting));
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void llamarFavoritos()
    {
        cargarMascotaHardcodeadas();
        Intent intent = new Intent(Petagram.this,Mfavoritos.class);
        intent.putExtra("favoritos",mascotaHardcodeadas);
        intent.putExtra("mascotas",mascotas);
        startActivity(intent);
        finish();
    }

    public void cargarMascotaHardcodeadas()
    {
        for (Mascota mascota:mascotas)
        {
            if(mascota.getRaiting()!= "0" && mascota.getRaiting()!= null)
            {
                mascotaHardcodeadas.add(mascota);
            }
        }
    }
}
