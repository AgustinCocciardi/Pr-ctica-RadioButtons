package com.example.ejercicioradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private RadioButton sumar;
    private RadioButton restar;
    private RadioButton multiplicar;
    private RadioButton dividir;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.valor1);
        valor2 = (EditText) findViewById(R.id.valor2);
        sumar = (RadioButton) findViewById(R.id.sumar);
        restar = (RadioButton) findViewById(R.id.restar);
        multiplicar = (RadioButton) findViewById(R.id.multiplicar);
        dividir = (RadioButton) findViewById(R.id.dividir);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void Calcular(View view){
        String numero1 = valor1.getText().toString();
        String numero2 = valor2.getText().toString();
        String resultadoCuenta = "";

        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);

        if(sumar.isChecked()){
            resultadoCuenta = String.valueOf(num1 + num2);
        }
        else{
            if(restar.isChecked())
                resultadoCuenta = String.valueOf(num1 - num2);
            else{
                if(multiplicar.isChecked())
                    resultadoCuenta = String.valueOf(num1 * num2);
                else{
                    if(dividir.isChecked()){
                        if(num2 == 0)
                            Toast.makeText(this,"El divisor debe ser distinto de cero", Toast.LENGTH_SHORT).show();
                        else
                            resultadoCuenta = String.valueOf(num1 / num2);
                    }
                }
            }
        }

        resultado.setText(resultadoCuenta);
    }
}
