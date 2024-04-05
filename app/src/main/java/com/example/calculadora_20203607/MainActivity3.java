package com.example.calculadora_20203607;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {



    private TextView operationTextView;
    private TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        operationTextView = findViewById(R.id.operation);
        resultTextView = findViewById(R.id.result);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        operationTextView.setText(""); // Establecer texto inicial vacío
        resultTextView.setText(""); // Establecer texto inicial vacío





        // Obtener referencias a los botones numéricos
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);



        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("9");
            }
        });



        Button buttonClear = findViewById(R.id.button_clear);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationTextView.setText("");
                resultTextView.setText("");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentOperation = operationTextView.getText().toString();
                String[] operands;
                double result = 0;

                if (currentOperation.contains("+")) {
                    operands = currentOperation.split("\\+");
                    result = Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]);
                } else if (currentOperation.contains("-")) {
                    operands = currentOperation.split("-");
                    result = Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]);
                } else if (currentOperation.contains("*")) {
                    operands = currentOperation.split("\\*");
                    result = Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]);
                } else if (currentOperation.contains("/")) {
                    operands = currentOperation.split("/");
                    if (Double.parseDouble(operands[1]) != 0) {
                        result = Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]);
                    } else {
                        resultTextView.setText("Error: Division by zero");
                        return;
                    }
                }

                resultTextView.setText(String.valueOf(result));
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToOperation("/");
            }
        });
    }






    private void appendToOperation(String value) {
        String currentOperation = operationTextView.getText().toString();
        currentOperation += value;
        operationTextView.setText(currentOperation);
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu4_main,menu);
        return true;
    }

    public void historialBtn(MenuItem menuItem){
        Intent intent = new Intent(this, MainActivity4.class);
        //se procede a mandar
        startActivity(intent);
    }







}