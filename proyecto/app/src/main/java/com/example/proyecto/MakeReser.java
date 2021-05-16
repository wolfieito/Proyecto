package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class MakeReser extends AppCompatActivity {

    Spinner spinner;
    EditText edTxtNom;
    Intent intent;
    RadioGroup rdGrpMesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reser);
        spinner = findViewById(R.id.spinner);
        intent = getIntent();
        rdGrpMesa = findViewById(R.id.rdGrpMesa);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.num_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        edTxtNom = findViewById(R.id.edtTxtNom);
    }

    public void onClickCierr(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    public void onClickAceptReser(View v){
        if(edTxtNom.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Por favor introduzca un nombre",Toast.LENGTH_LONG).show();
        }else {
            intent.putExtra("NOMBRE",edTxtNom.getText().toString());
            intent.putExtra("PERSONAS",spinner.getSelectedItem().toString());
            intent.putExtra("DENTRO",getRadioText(rdGrpMesa.getCheckedRadioButtonId()));
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }
    public void hidekeyboard(View v){
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
    public String getRadioText(int id){
        RadioButton rdBton;
        int selectedId = id;
        rdBton = (RadioButton) findViewById(selectedId);
        return rdBton.getText().toString();
    }


}