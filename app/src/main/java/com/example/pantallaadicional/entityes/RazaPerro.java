package com.example.pantallaadicional.entityes;

import com.google.gson.annotations.SerializedName;

public class RazaPerro {
    public int id;
    public String name;
    @SerializedName("bred_for")//para agregar nombre del atributo Gson
    public String bredFor;
    @SerializedName("breed_group")
    public String breedGroup;
    @SerializedName("life_span")
    public String lifeSpan;
    public String temperament;
    public imgRazaPerro image;
}
