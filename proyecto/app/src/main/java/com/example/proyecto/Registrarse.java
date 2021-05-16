package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;

public class Registrarse extends AppCompatActivity {

    EditText edTxtUsuRegi, edTxtNomRegi, edTxtApeRegi, edTxtTelRegi, edTxtConRegi;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        edTxtUsuRegi = findViewById(R.id.edTxtUsuRegi);
        edTxtNomRegi = findViewById(R.id.edTxtNomRegi);
        edTxtApeRegi = findViewById(R.id.edTxtApeRegi);
        edTxtTelRegi = findViewById(R.id.edTxtTelRegi);
        edTxtConRegi = findViewById(R.id.edTxtConRegi);
        intent = new Intent(this,Opciones.class);
    }

    public void onClickRegis(View v){
            FetchData dataConsulter = new FetchData(this);

            JSONObject postData = new JSONObject();
            try {
                postData.put("usuario", edTxtUsuRegi.getText().toString());
                postData.put("nombre", edTxtNomRegi.getText().toString());
                postData.put("apellidos", edTxtApeRegi.getText().toString());
                postData.put("numTel", edTxtTelRegi.getText().toString());
                postData.put("password", edTxtConRegi.getText().toString());



            } catch (JSONException e) {
                e.printStackTrace();
            }

            Response.Listener<JSONObject>  onResponse = new Response.Listener<JSONObject>(){
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if(response.getBoolean("succ") == true) {
                            Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),response.getString("error"), Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            dataConsulter.fetch(Request.Method.POST,"register",postData,onResponse);
        }
        public void onClickCncel(View v){
            finish();
        }
    }