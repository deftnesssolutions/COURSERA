package com.androicoude.reciclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView nombre, nacimiento, telefono, email, descripcion;
    String msg="Presione el boton Salir para editar o salir del aplicativo";
    Button editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Intent extras = getIntent();
        if(extras !=null)
        {
            Bundle recibirExtras = extras.getExtras();
            if(recibirExtras !=null)
            {
                capturarObjetos();
                nombre.setText(recibirExtras.getString(getResources().getString(R.string.extra_nombre)));
                //nacimiento.setText(recibirExtras.getString(getResources().getString(R.string.extra_nacimiento)));
                telefono.setText(recibirExtras.getString(getResources().getString(R.string.extra_telefono)));
                email.setText(recibirExtras.getString(getResources().getString(R.string.extra_email)));
                //descripcion.setText(recibirExtras.getString(getResources().getString(R.string.extra_descripcion)));
            }
        }

    }
    public void capturarObjetos()//Metodo para capturar objetos del activity
    {
        editar = (Button) findViewById(R.id.btn_editar);
        nombre = (TextView) findViewById(R.id.tv_Nombre);
        nacimiento = (TextView) findViewById(R.id.tv_extraNancimiento);
        telefono = (TextView) findViewById(R.id.tv_extraTel);
        email = (TextView) findViewById(R.id.tv_extraEmail);
        descripcion = (TextView) findViewById(R.id.tv_extraDescripcion);
    }
}
