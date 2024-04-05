package com.example.calculadora_20203607;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {


    private List<String> resultList = new ArrayList<>();
    private TextView indicationsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        indicationsTextView = findViewById(R.id.indicationsTextView);


        // Obtener la lista resultList del Intent
        Intent intent = getIntent();
        if (intent != null) {
            resultList = intent.getStringArrayListExtra("resultList");
            if (resultList != null) {
                // Mostrar los resultados en el TextView
                showResults();
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }






    private void showResults() {
        StringBuilder sb = new StringBuilder();
        int k = 1;
        for (String result : resultList) {
            sb.append("Resultado ").append(k).append(": ").append(result).append("\n");
            k++;
        }
        // Establecer el texto con el formato deseado en el TextView
        indicationsTextView.setText(sb.toString());
    }
}