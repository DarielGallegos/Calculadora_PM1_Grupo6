package com.example.calculadora;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements calculadoraMethods{

    private Button btnSuma;
    private Button btnResta;
    private Button btnMultiplicacion;
    private Button btnDivision;
    private TextView num1;
    private TextView num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMulti);
        btnDivision = findViewById(R.id.btnDiv);
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = sum(parseInt(num1.getText().toString()), parseInt(num2.getText().toString()));
                Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
                intent.putExtra("result", res);
                startActivity(intent);
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = rest(parseInt(num1.getText().toString()), parseInt(num2.getText().toString()));
                Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
                intent.putExtra("result", res);
                startActivity(intent);
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = div(parseInt(num1.getText().toString()), parseInt(num2.getText().toString()));
                Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
                intent.putExtra("result", res);
                startActivity(intent);
            }
        });
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res = mult(parseInt(num1.getText().toString()), parseInt(num2.getText().toString()));
                Intent intent = new Intent(getApplicationContext(), ActivityResultado.class);
                intent.putExtra("result", res);
                startActivity(intent);
            }
        });
    }

    @Override
    public double sum(int a, int b) {
        return a + b;
    }

    @Override
    public double rest(int a, int b) {
        return a - b;
    }

    @Override
    public double mult(int a, int b) {
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        return (double) a / b;
    }
}