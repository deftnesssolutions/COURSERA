package com.androicoude.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class Mfavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas,mascotasFavoritos;

    private RecyclerView mascotaFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfavoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.drawable.dog_footprint_52);

        mascotaFavoritos = (RecyclerView) findViewById(R.id.rvMfavorito);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mascotaFavoritos.setLayoutManager(llm);

        Intent extras = getIntent();
        if(extras !=null)
        {
            Bundle recibirExtras = extras.getExtras();
            if(recibirExtras !=null)
            {
                mascotas = recibirExtras.getParcelableArrayList("mascotas");
                mascotasFavoritos = recibirExtras.getParcelableArrayList("favoritos");

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
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                volverAtras();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavoritos,this);
        mascotaFavoritos.setAdapter(adaptador);
    }

    public void volverAtras()
    {
        Intent intent = new Intent(Mfavoritos.this,Petagram.class);
        intent.putExtra("mascotas",mascotas);
        startActivity(intent);
        finish();
    }


}
