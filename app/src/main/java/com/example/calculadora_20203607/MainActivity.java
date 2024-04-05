package com.example.calculadora_20203607;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView teleMathTextView;
    private int colorIndex = 0;
    private final int[] colors = {Color.RED, Color.GREEN, Color.BLUE};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        teleMathTextView = findViewById(R.id.textView4);
        registerForContextMenu(teleMathTextView);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }







    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Método para manejar las acciones al seleccionar una opción del menú contextual
    /*@Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue_option:
                changeTextColor(Color.BLUE);
                return true;
            case R.id.green_option:
                changeTextColor(Color.GREEN);
                return true;
            case R.id.red_option:
                changeTextColor(Color.RED);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }




     */

    // Método para cambiar el color del TextView
    private void changeTextColor(int color) {
        teleMathTextView.setTextColor(color);
    }















    public void irAIndicaciones(View view) {



        //aca esta mandando esta data con sus respectivos keys a mainactivity2
        //tambien puedes usar intent.setData(Uri.parse("https://pucp.edu.pe")
        //en el otro lado recibiria con intent = getIntent(); Uri data = intent.getData()
        Intent intent = new Intent(this, MainActivity2.class);
        //se procede a mandar
        startActivity(intent);

    }

    public void irACalculadora(View view) {



        //aca esta mandando esta data con sus respectivos keys a mainactivity2
        //tambien puedes usar intent.setData(Uri.parse("https://pucp.edu.pe")
        //en el otro lado recibiria con intent = getIntent(); Uri data = intent.getData()
        Intent intent = new Intent(this, MainActivity3.class);
        //se procede a mandar
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu4_main,menu);
        return true;
    }






}