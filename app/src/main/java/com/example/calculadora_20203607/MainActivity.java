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

    private int colorIndex = 0;
    private final int[] colors = {Color.RED, Color.GREEN, Color.BLUE};



    //se define un object textview
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //se va a guardar en el textview4 q es el que meustra lo de telemath
        textView = findViewById(R.id.textView4);

        // Registrar el menú contextual para el TextView
        registerForContextMenu(textView);





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

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.green) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            return true;
        } else if (id == R.id.blue) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            return true;







        } else if (id == R.id.red) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return true;
        }

        return super.onContextItemSelected(item);
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






}