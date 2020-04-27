package com.example.sistemaempresarial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtHoras;
    EditText edtValor;
    EditText edtSalarioBruto;
    EditText edtDesconto;
    EditText edtSalarioLiquido;
    RadioGroup RGpercentual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHoras = (EditText) findViewById(R.id.edtHoras);
        edtValor = (EditText) findViewById(R.id.edtValor);
        edtSalarioBruto = (EditText) findViewById(R.id.edtSalarioBruto);
        edtDesconto = (EditText) findViewById(R.id.edtDesconto);
        edtSalarioLiquido = (EditText) findViewById(R.id.edtSalarioLiquido);
        RGpercentual = (RadioGroup) findViewById(R.id.RGpercentual);

    }

    public void onCalcularClick(View v) {
        double horas = Double.parseDouble(edtHoras.getText().toString());
        double valor = Double.parseDouble(edtValor.getText().toString());
        double salarioBruto = horas * valor;
        edtSalarioBruto.setText(String.valueOf(salarioBruto));
        double desconto;
        double salarioLiquido;

        if (RGpercentual.getCheckedRadioButtonId() == R.id.rb10){
            desconto = salarioBruto * 0.10;
        } else if(RGpercentual.getCheckedRadioButtonId() == R.id.rb15) {
            desconto = salarioBruto * 0.15;
        } else {
            desconto = salarioBruto * 0.20;
        }
        edtDesconto.setText(String.valueOf(desconto));
        salarioLiquido = salarioBruto - desconto;
        edtSalarioLiquido.setText(String.valueOf(salarioLiquido));

    }
}
