package com.example.divideconta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtConsumo;
    EditText edtCouvert;
    RadioGroup rgTaxa;
    RadioGroup rgPessoas;
    EditText edtTotal;
    EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtConsumo = (EditText) findViewById(R.id.edtConsumo);
        edtCouvert = (EditText) findViewById(R.id.edtCouvert);
        rgTaxa = (RadioGroup) findViewById(R.id.rgTaxa);
        rgPessoas = (RadioGroup) findViewById(R.id.rgPessoas);
        edtTotal = (EditText) findViewById(R.id.edtTotal);
        edtValor = (EditText) findViewById(R.id.edtValor);
    }

    public void onDividirClick(View v) {
        double consumo = Double.parseDouble(edtConsumo.getText().toString());
        double couvert = Double.parseDouble(edtCouvert.getText().toString());
        double total = consumo;
        double valor;


        if(rgTaxa.getCheckedRadioButtonId() == R.id.rbSim){
            total = consumo + consumo * 0.10;
        }

        if(rgPessoas.getCheckedRadioButtonId() == R.id.rb2){
            total = total + couvert * 2;
            valor = total / 2;
        }
        else if(rgPessoas.getCheckedRadioButtonId() == R.id.rb3){
            total = total + couvert * 3;
            valor = total / 3;
        }
        else  if(rgPessoas.getCheckedRadioButtonId() == R.id.rb4){
            total = total + couvert * 4;
            valor = total / 4;
        }
        else {
            total = total + couvert * 5;
            valor = total / 5;
        }

        edtTotal.setText(String.valueOf(total));
        edtValor.setText(String.valueOf(valor));
    }
}
