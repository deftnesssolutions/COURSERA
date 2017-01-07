package com.androicoude.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditContacto extends AppCompatActivity {

    TextView nombre, nacimiento, telefono, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contacto);

        Bundle extras = getIntent().getExtras();
        String xnombre = extras.getString(getResources().getString(R.string.extra_nombre));
        String xnacimiento = extras.getString(getResources().getString(R.string.extra_nacimiento));
        String xtelefono = extras.getString(getResources().getString(R.string.extra_telefono));
        String xemail = extras.getString(getResources().getString(R.string.extra_email));
        String xdescripcion = extras.getString(getResources().getString(R.string.extra_descripcion));

        capturarObjetos();

        nombre.setText(xnombre);
        nacimiento.setText(xnacimiento);
        telefono.setText(xtelefono);
        email.setText(xemail);
        descripcion.setText(xdescripcion);

    }

    public void capturarObjetos()
    {
        nombre = (TextView) findViewById(R.id.tv_Nombre);
        nacimiento = (TextView) findViewById(R.id.tv_extraNancimiento);
        telefono = (TextView) findViewById(R.id.tv_extraTel);
        email = (TextView) findViewById(R.id.tv_extraEmail);
        descripcion = (TextView) findViewById(R.id.tv_extraDescripcion);
    }
}
