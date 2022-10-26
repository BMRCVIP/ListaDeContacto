package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.example.pantallaadicional.adapters.RazaPerrosAdapater;
import com.example.pantallaadicional.entityes.RazaPerro;
import com.example.pantallaadicional.services.RazaPerrosServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListRazaPerrosActivity extends AppCompatActivity {

    private RecyclerView rvRaza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_raza_perros);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RazaPerrosServices services = retrofit.create(RazaPerrosServices.class);
        services.getListPerros().enqueue(new Callback<List<RazaPerro>>() {
            @Override
            public void onResponse(Call<List<RazaPerro>> call, Response<List<RazaPerro>> response)
            {
                List<RazaPerro> data= response.body();
                rvRaza=findViewById(R.id.rvRazaPerros);
                rvRaza.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvRaza.setAdapter(new RazaPerrosAdapater(data));
                Log.i("MAIN_APP", "RESPONSE:"+response.body().size());
                Log.i("MAIN_APP", new Gson().toJson(data));
            }

            @Override
            public void onFailure(Call<List<RazaPerro>> call, Throwable t) {

            }
        });
    }
}