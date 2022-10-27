package com.example.pantallaadicional.services;

import com.example.pantallaadicional.entityes.ContactApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContactApiService {
    //todo esto depende del API( GET SET DELETE )
    @GET("contacts")
    Call<List<ContactApi>> getListContact();
    @POST("contacts")
    Call<Void> create(@Body ContactApi contactApi);//guardar datos
    /*@PUT("contacts/{id}")
    Call<Void> update (@Body ContactApi contactApi, @Path("id")int id);*/
    @PUT("contacts/{id}")
    Call<ContactApi> update(@Body ContactApi contactApi, @Path("id")int id);
    @DELETE("contacts/{id}")
    Call<ContactApi> delete (@Path("id")int id);
}
