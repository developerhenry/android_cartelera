package com.example.et.mycartelera;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void onClickRegistroIncio(View target){
        Intent inicio = new Intent(Registro.this,MainActivity.class );
        Registro.this.startActivity(inicio);
    }

    public void whenPostJson_thenCorrect(View target) throws IOException {

        EditText txtNombre = findViewById(R.id.editTextNombre);
        EditText txtUsuario = findViewById(R.id.editTextUsuario);
        EditText txtclave = findViewById(R.id.editTextClave);


        String nombre = txtNombre.getText().toString();
        String usuario = txtUsuario.getText().toString();
        String clave = txtclave.getText().toString();

        // String json = "{\"nombre\":\"Prueba 111\",\"usuario\":\"prueba1\",\"clave\":\"123456\"}";
        String json = "{\"nombre\": \"" + nombre + "\",\"usuario\":\"" + usuario + "\",\"clave\":\"" + clave + "\"}";
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url("http://173.255.200.97:8009/usuario/insertar")
                .post(body)
                .build();

        // Call call =  client.newCall(request);
        // Response response = call.execute();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response )  throws IOException {
                String mMessage = response.body().string();
               // Log.e(TAG, mMessage);
            }
        });
        TextView viewMensage = findViewById(R.id.textViewMensage);
        viewMensage.setText("Datos Guardados Correctamente");
        viewMensage.setTextColor(Color.BLUE);
        txtUsuario.setText("");
        txtNombre.setText("");
        txtclave.setText("");
        // return response.body().string();
        // assertThat(response.code(), equalTo(200));
    }
}
