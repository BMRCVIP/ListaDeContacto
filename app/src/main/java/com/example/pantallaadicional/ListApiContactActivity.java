package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pantallaadicional.adapters.APIContactsAdapter;
import com.example.pantallaadicional.adapters.RazaPerrosAdapater;
import com.example.pantallaadicional.entityes.ContactApi;
import com.example.pantallaadicional.entityes.RazaPerro;
import com.example.pantallaadicional.services.ContactApiService;
import com.example.pantallaadicional.services.RazaPerrosServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListApiContactActivity extends AppCompatActivity {

    private RecyclerView rvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_api_contact);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63597f5cff3d7bddb9a3cca2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactApiService services = retrofit.create(ContactApiService.class);
        services.getListContact().enqueue(new Callback<List<ContactApi>>() {
            @Override
            public void onResponse(Call<List<ContactApi>> call, Response<List<ContactApi>> response) {
                List<ContactApi> datos = response.body();
                rvContact=findViewById(R.id.rvContactos);
                rvContact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvContact.setAdapter(new APIContactsAdapter(datos));
            }

            @Override
            public void onFailure(Call<List<ContactApi>> call, Throwable t) {

            }
        });

    }
}