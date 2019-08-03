package com.example.et.mycartelera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickIncio(View target){
        Intent inicio = new Intent(Menu.this,MainActivity.class );
        Menu.this.startActivity(inicio);
    }
}
