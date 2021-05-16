package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String Usuario, Nombre, Apellido, Telefono;
    EditText edTxtNom,edTxtCon;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtCon = findViewById(R.id.edTxtCon);
        edTxtNom = findViewById(R.id.edTxtNom);
        intent = new Intent(this, Opciones.class);
    }

    public void openOpc(View v){
        FetchData dataConsulter = new FetchData(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put("usuario", edTxtNom.getText().toString());
            postData.put("password", edTxtCon.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Response.Listener<JSONObject>  onResponse = new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.has("error")) {
                        Toast.makeText(getApplicationContext(), response.getString("error"), Toast.LENGTH_LONG).show();
                    }
                    else
                        startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        dataConsulter.fetch(Request.Method.POST,"log",postData,onResponse);
    }

    public void openRegis(View v){
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }
    public void hidekeyboard(View v){
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    public String getUsuario(){
        return Usuario;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public String getTelefono(){
        return Telefono;
    }
}