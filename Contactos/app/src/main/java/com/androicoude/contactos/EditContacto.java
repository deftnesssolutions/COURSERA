package com.androicoude.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditContacto extends AppCompatActivity implements View.OnClickListener {

    TextView nombre, nacimiento, telefono, email, descripcion;
    String msg="Presione el boton Salir para editar o salir del aplicativo";
    Button editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contacto);

        capturarObjetos();
        recuperaExtras();
        editar.setOnClickListener(this);
    }

    @Override
    public  void onBackPressed ()  {// Bloqueo el boton back
        // hacer algo por debajo.
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        return ;
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

    public void recuperaExtras() //Methodo para capturar extras enviado desde otro activity
    {
        Intent extras = getIntent();
        if(extras !=null)
        {
            Bundle recibirExtras = extras.getExtras();
            if(recibirExtras !=null)
            {
                capturarObjetos();
                nombre.setText(recibirExtras.getString(getResources().getString(R.string.extra_nombre)));
                nacimiento.setText(recibirExtras.getString(getResources().getString(R.string.extra_nacimiento)));
                telefono.setText(recibirExtras.getString(getResources().getString(R.string.extra_telefono)));
                email.setText(recibirExtras.getString(getResources().getString(R.string.extra_email)));
                descripcion.setText(recibirExtras.getString(getResources().getString(R.string.extra_descripcion)));
            }
        }


    }

    @Override
    public void onClick(View v) {
        if(v==editar)
        {
            Intent intent = new Intent(EditContacto.this,MainActivity.class);
            intent.putExtra(getResources().getString(R.string.extra_nombre), nombre.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_nacimiento), nacimiento.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_telefono), telefono.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_email), email.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_descripcion), descripcion.getText().toString());
            startActivity(intent);
            finish();
        }
    }
}
