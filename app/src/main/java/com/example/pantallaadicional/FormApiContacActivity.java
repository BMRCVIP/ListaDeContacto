package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pantallaadicional.adapters.APIContactsAdapter;
import com.example.pantallaadicional.entityes.ContactApi;
import com.example.pantallaadicional.services.ContactApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormApiContacActivity extends AppCompatActivity {

    EditText etName, etLastName;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_contac);

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);

        button=findViewById(R.id.btnSiguiente);
        button.setOnClickListener(v ->{
                onClick(v);
                });

        /*ContactApi contactApi = new ContactApi();
        contactApi.name="Brandon";
        contactApi.lastname="Rodriguez";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63597f5cff3d7bddb9a3cca2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactApiService service = retrofit.create(ContactApiService.class);
        service.craate(contactApi).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("MAIN_APP", "RESPONSE"+ response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });*/
    }

    private void onClick(View v) {
        Intent intent = new Intent(this, ListApiContactActivity.class);
        startActivity(intent);

    }

    public void enviar(View v){
        String name = etName.getText().toString();
        String lastname = etLastName.getText().toString();
        ContactApi contactApi = new ContactApi();
        contactApi.name=name;
        contactApi.lastname=lastname;
        postRetrofit(contactApi);
    }
    public  void postRetrofit(ContactApi contactApi){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63597f5cff3d7bddb9a3cca2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactApiService service = retrofit.create(ContactApiService.class);
        service.create(contactApi).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("MAIN_APP", "RESPONSE"+ response.code());
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }

    /*public void updateRetrofit(ContactApi contactApi, int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63597f5cff3d7bddb9a3cca2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactApiService service = retrofit.create(ContactApiService.class);
        service.update(contactApi, id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.i("MAIN_APP", "RESPONSE"+ response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }*/
}