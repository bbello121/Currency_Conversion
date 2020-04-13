package com.example.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double euroRate = .91612;
    double mexPesos = 23.59;
    double canDollar = 1.38796;
    double dollarEntered;
    double convertedTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText userEntered = (EditText)findViewById(R.id.txtCurrency);
        final RadioButton euroRad = (RadioButton)findViewById(R.id.radEuro);
        final RadioButton mexPesosRad = (RadioButton)findViewById(R.id.radPesos);
        final RadioButton canDollarRad = (RadioButton)findViewById(R.id.radCanDollar);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dollarEntered = Double.parseDouble(userEntered.getText().toString());
                DecimalFormat dollar = new DecimalFormat("$#,###.00");
                DecimalFormat euro = new DecimalFormat("€#,###.00");
                DecimalFormat pesos = new DecimalFormat("#,###.00");

                if(dollarEntered < 100000){
                    if(euroRad.isChecked()){
                        convertedTotal = dollarEntered * euroRate;
                        result.setText("The converted amount is " + euro.format(convertedTotal));
                    }
                    else if(mexPesosRad.isChecked()){
                        convertedTotal = dollarEntered* mexPesos;
                        result.setText("The converted amount is " + pesos.format(convertedTotal));
                    }
                    else if(canDollarRad.isChecked()){
                        convertedTotal = dollarEntered * canDollar;
                        result.setText("The converted amount is " + dollar.format(convertedTotal) + " mexican pesos");
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Dollars to convert must be less than $100,000", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
