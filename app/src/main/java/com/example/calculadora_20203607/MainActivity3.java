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

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {


    private List<String> resultList = new ArrayList<>();
    private TextView indicationsTextView;
    private TextView operationTextView;
    private TextView resultTextView;

    private StringBuilder operation = new StringBuilder();
    private boolean isNewOperation = true;


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


                boolean flag_division_cero = false; //esta se activa si hubo div por zero


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
                        resultTextView.setText("ERROR!!!! NO SE PUEDE DIVIDIR POR ZERO");
                        flag_division_cero = true;
                        return;
                    }
                }



                resultTextView.setText(String.valueOf(result));


                //se guarda en historial
                if(!flag_division_cero){
                    String resultString = String.valueOf(result);
                    resultList.add(resultString);
                }




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






    // Método para manejar el clic de los botones de números y operadores
    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        // Si se inicia una nueva operación, limpiar los TextViews
        if (isNewOperation) {
            operation.setLength(0);
            resultTextView.setText("");
            isNewOperation = false;
        }

        // Concatenar el texto del botón a la operación actual
        operation.append(buttonText);
        operationTextView.setText(operation.toString());
    }

    // Método para manejar el clic del botón igual
    public void onEqualsClick(View view) {
        // Evaluar la operación y mostrar el resultado
        evaluateOperation();
        isNewOperation = true;
        operation.setLength(0); // Limpiar la operación
        operationTextView.setText(""); // Limpiar el TextView de la operación

    }

    // Método para manejar el clic del botón de borrar todo
    public void onClearAllClick(View view) {
        // Limpiar la operación y los TextViews
        operation.setLength(0);
        operationTextView.setText("");
        resultTextView.setText("");
        isNewOperation = true;
    }

    // Método para evaluar la operación actual y mostrar el resultado
    private void evaluateOperation() {
        String operationText = operation.toString();
        // Aquí puedes evaluar la operación y mostrar el resultado en el TextView adecuado
        // Asegúrate de manejar adecuadamente los errores de evaluación
        // Por ejemplo:
        try {
            double result = eval(operationText);
            resultTextView.setText(String.valueOf(result));
        } catch (ArithmeticException | NumberFormatException e) {
            resultTextView.setText("Error");
        }
    }

    // Método para evaluar una expresión matemática
    private double eval(String expression) {
        // Implementa la lógica de evaluación de expresiones aquí
        // Este es solo un ejemplo básico para evaluar expresiones matemáticas simples
        // Puedes usar una librería como exp4j para evaluaciones más avanzadas
        // Por ejemplo:
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm(); // suma
                    else if (eat('-')) x -= parseTerm(); // resta
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor(); // multiplicación
                    else if (eat('/')) x /= parseFactor(); // división
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // operador unario positivo
                if (eat('-')) return -parseFactor(); // operador unario negativo
                double x;
                int startPos = this.pos;
                if (eat('(')) { // paréntesis
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // números
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                return x;
            }
        }.parse();
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
        //se procede a mandar la lista de resultados
        intent.putStringArrayListExtra("resultList", new ArrayList<>(resultList));

        startActivity(intent);
    }







}