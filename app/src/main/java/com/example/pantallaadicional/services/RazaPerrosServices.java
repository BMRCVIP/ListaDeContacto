package com.example.pantallaadicional.services;

import com.example.pantallaadicional.entityes.RazaPerro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
//si la primera es una llave, es una lista
public interface RazaPerrosServices {
    //https://api.thedogapi.com/v1/breeds?limit=20&page=0
    //ruta para consultar desde la API
    @GET("v1/breeds?limit=10&page=0")
    Call<List<RazaPerro>> getListPerros();
}
