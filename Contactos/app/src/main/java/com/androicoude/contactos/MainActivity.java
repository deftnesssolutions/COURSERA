package com.androicoude.contactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.WindowManager;
import android.text.TextUtils;
import java.util.Calendar;

import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton calendario;
    EditText fecha,nombre,telefono,email,descripcion;
    private int dia, mes, ano;
    Button siguiente;
    TextInputLayout til_nombre,til_nacimiento,til_telefono,til_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capturarObjetos();

        calendario.setOnClickListener(this);
        siguiente = (Button) findViewById(R.id.btn_siguiente);
        siguiente.setOnClickListener(this);

    }

    public void controlError()
    {
        nombre.addTextChangedListener(new MyTextWatcher(nombre));
        fecha.addTextChangedListener(new MyTextWatcher(fecha));
        telefono.addTextChangedListener(new MyTextWatcher(telefono));
        email.addTextChangedListener(new MyTextWatcher(email));
    }
    public void capturarObjetos()
    {
        calendario = (ImageButton) findViewById(R.id.btn_setdate);
        nombre= (EditText) findViewById(R.id.et_nombre);
        fecha = (EditText) findViewById(R.id.et_nacimiento);
        telefono = (EditText) findViewById(R.id.et_telefono);
        email = (EditText) findViewById(R.id.et_email);
        descripcion = (EditText) findViewById(R.id.et_descripcion);

        til_nombre = (TextInputLayout) findViewById(R.id.input_layout_name);
        til_nacimiento = (TextInputLayout) findViewById(R.id.input_layout_fecha_nacimiento);
        til_telefono = (TextInputLayout) findViewById(R.id.input_layout_email);
        til_email = (TextInputLayout) findViewById(R.id.input_layout_telefono);

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


            capturarObjetos();
            controlError();
            submitForm();

        }
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateNacimineto())
        {
            return;
        }

        if(!validateTelefono())
        {
            return;
        }
        if (!validateEmail()) {
            return;
        }

        /*if (!validatePassword()) {
            return;
        }*/
        Intent intent = new Intent(MainActivity.this,EditContacto.class);
        intent.putExtra(getResources().getString(R.string.extra_nombre), nombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_nacimiento), fecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_telefono), telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_email), email.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_descripcion), descripcion.getText().toString());
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private boolean validateName() {
        if (nombre.getText().toString().trim().isEmpty()) {
            til_nombre.setError(getString(R.string.err_msg_name));
            requestFocus(nombre);
            return false;
        } else {
            til_nombre.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNacimineto() {
        if (fecha.getText().toString().trim().isEmpty()) {
            til_nacimiento.setError(getString(R.string.err_msg_name));
            requestFocus(fecha);
            return false;
        } else {
            til_nacimiento.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTelefono() {
        if (telefono.getText().toString().trim().isEmpty()) {
            til_telefono.setError(getString(R.string.err_msg_name));
            requestFocus(telefono);
            return false;
        } else {
            til_telefono.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateEmail() {
        String xemail = email.getText().toString().trim();

        if (xemail.isEmpty() || !isValidEmail(xemail)) {
            til_email.setError(getString(R.string.err_msg_email));
            requestFocus(email);
            return false;
        } else {
            til_email.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String xemail) {
        return !TextUtils.isEmpty(xemail) && android.util.Patterns.EMAIL_ADDRESS.matcher(xemail).matches();
    }
   /* private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }*/

    private class MyTextWatcher implements TextWatcher{
        private View view;

        private MyTextWatcher(View v)
        {
            this.view=v;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.et_nombre:
                    validateName();
                    break;
                case R.id.et_nacimiento:
                    validateNacimineto();
                    break;
                case R.id.et_telefono:
                    validateTelefono();
                    break;
                case R.id.et_email:
                    validateEmail();
                    break;
                /*case R.id.input_password:
                    validatePassword();
                    break;*/
            }
        }
    }
}
