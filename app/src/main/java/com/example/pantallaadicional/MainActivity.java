package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pantallaadicional.adapters.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Lo declaramos
    private RecyclerView rvNombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lista de datos para pasarlo al adapter
        List<String>nombres= new ArrayList<String>();
        nombres.add("Brandon");
        nombres.add("Manuel");
        nombres.add("Rodriguez");
        //lo llamamos
        rvNombres = findViewById(R.id.rvNombres);
        rvNombres.setLayoutManager(new LinearLayoutManager(this));
        rvNombres.setAdapter(new StringAdapter(nombres));
    }
}