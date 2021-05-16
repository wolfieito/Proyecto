package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
    }

    public void onClickCierr(View v){
        finish();
    }

    public void onClickReservar(View v){
        Intent intent = new Intent(this,Reservar.class);
        startActivity(intent);
    }

    public void onClickRevisar(View v){
        Intent intent = new Intent(this,Revisar.class);
        startActivity(intent);
    }
    public void onClickReservas(View v){
        Intent intent = new Intent(this,Reservas.class);
        startActivity(intent);
    }
    public void onClickCuenta(View v){
        Intent intent = new Intent(this,Cuenta.class);
        startActivity(intent);
    }
}