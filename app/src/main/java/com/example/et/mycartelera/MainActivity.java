package com.example.et.mycartelera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickIngresar(View target){
        // txtUsuario = findViewById(R.id.editTxtUsuario);
        // txtUsuario.setText("Hola 2");
        // txtUsuario.getText();
        Intent ingreso = new Intent(MainActivity.this,Menu.class );
        MainActivity.this.startActivity(ingreso);
    }

    public void onClickRegistroUsuario(View target){
        Intent registro = new Intent(MainActivity.this,Registro.class );
        MainActivity.this.startActivity(registro);
    }
}
