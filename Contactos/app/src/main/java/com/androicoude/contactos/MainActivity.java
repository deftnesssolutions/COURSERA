package com.androicoude.contactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton calendario;
    EditText fecha,nombre,telefono,email,descripcion;
    private int dia, mes, ano;
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendario = (ImageButton) findViewById(R.id.btn_setdate);
        nombre= (EditText) findViewById(R.id.et_nombre);
        fecha = (EditText) findViewById(R.id.et_nacimiento);

        calendario.setOnClickListener(this);
        siguiente = (Button) findViewById(R.id.btn_siguiente);
        siguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==calendario)
        {
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            },dia,mes,ano);
            datePickerDialog.show();
        }

        if(v==siguiente)
        {

            telefono = (EditText) findViewById(R.id.et_telefono);
            email = (EditText) findViewById(R.id.et_email);
            descripcion = (EditText) findViewById(R.id.et_descripcion);

            Intent intent = new Intent(MainActivity.this,EditContacto.class);
            intent.putExtra(getResources().getString(R.string.extra_nombre), nombre.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_nacimiento), fecha.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_telefono), telefono.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_email), email.getText().toString());
            intent.putExtra(getResources().getString(R.string.extra_descripcion), descripcion.getText().toString());
            startActivity(intent);
        }
    }
}
