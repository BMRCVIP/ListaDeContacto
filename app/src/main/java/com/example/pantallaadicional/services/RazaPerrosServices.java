package com.example.pantallaadicional.services;

import com.example.pantallaadicional.entityes.RazaPerro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//si la primera es una llave, es una lista
public interface RazaPerrosServices {
    //https://api.thedogapi.com/v1/breeds?limit=20&page=0
    //ruta para consultar desde la API [] envia todos los datos
    //@GET("v1/breeds?limit=20&page=0")
    //Call<List<RazaPerro>> getListPerros1();
    @GET("v1/breeds")
    //se envia 3, cuando es un querry string (&) caso contrario no hacer nada
    Call<List<RazaPerro>> getListPerros(@Query("limit") int limit, @Query("page") int page);
  //  si solo queremos pasar un solo dato {}
    @GET("v1/breeds/{razaId}")
    Call<RazaPerro> obtenerID(@Path("razaId") int id);
}
