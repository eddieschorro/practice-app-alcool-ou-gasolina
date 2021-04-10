package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText precoAlcool, precoGasolina;
    TextView txtv_opcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.input_alcoolPreco);
        precoGasolina = findViewById(R.id.input_gasolinaPreco);
        txtv_opcao = findViewById(R.id.txtv_opcao);

    }

    public void calcularPreco(View view) {

        String txtPrecoAlcool = precoAlcool.getText().toString();
        String txtPrecoGasolina = precoGasolina.getText().toString();
        Boolean camposValidados = validarCampos(txtPrecoAlcool, txtPrecoGasolina);

        if (camposValidados) {

            double valorAlcool = Double.parseDouble(txtPrecoAlcool);
            double valorGasolina = Double.parseDouble(txtPrecoGasolina);

            if (valorAlcool > valorGasolina) {
                txtv_opcao.setText("Vale mais álcool");
            } else {
                txtv_opcao.setText("Vale mais gasoline");
            }
        } else if (!camposValidados){
            txtv_opcao.setText("falta preecnher campos");
        }
    }

    public Boolean validarCampos(String pA, String pG) {
        Boolean camposValidados = true;
        if (pA == null || pA.equals("")) {
            camposValidados = false;
        } else if (pG == null || pG.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    };
}