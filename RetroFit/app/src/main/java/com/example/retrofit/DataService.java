package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("E14trR2lD")
    Call<Pokemon> getPokemons();

    @GET("NympVMn2P")
    Call<List<Pokemon_>> getPokemonArray();



}
