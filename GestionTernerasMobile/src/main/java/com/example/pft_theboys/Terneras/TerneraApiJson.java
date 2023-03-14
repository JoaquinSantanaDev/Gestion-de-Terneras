package com.example.pft_theboys.Terneras;

import com.example.pft_theboys.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TerneraApiJson {

    //GET de la lista de usuarios
    @GET("listarTernera")//busca terneras en el URL del servicio
    Call<List<TerneraEntity>> getTerneras();

    @POST("crearTernera")
    Call<TerneraEntity> agregTernera(@Body TerneraEntity ternera);
}
