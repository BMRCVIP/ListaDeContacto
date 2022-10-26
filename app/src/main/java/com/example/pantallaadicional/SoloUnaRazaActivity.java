package com.example.pantallaadicional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pantallaadicional.entityes.RazaPerro;
import com.example.pantallaadicional.services.RazaPerrosServices;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoloUnaRazaActivity extends AppCompatActivity {

    ImageView ivImage2;
    TextView tvRaza2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_una_raza);

        ivImage2 = findViewById(R.id.ivImage2);
        tvRaza2 = findViewById(R.id.tvRaza2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thedogapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RazaPerrosServices services = retrofit.create(RazaPerrosServices.class);
        services.obtenerID(5).enqueue(new Callback<RazaPerro>() {
            @Override
            public void onResponse(Call<RazaPerro> call, Response<RazaPerro> response) {
                RazaPerro data = response.body();
                //Picasso.get().load(data.image.url).into(ivImage2);
                tvRaza2.setText(data.bredFor);


            }

            @Override
            public void onFailure(Call<RazaPerro> call, Throwable t) {

            }
        });
    }
}