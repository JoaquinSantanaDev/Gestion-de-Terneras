package com.example.pft_theboys;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.FormUrlEncoded;

public interface JsonPlaceHolderApi {
    //Esta clase es la que obtiene toda la informacion del JSON

    //GET de la lista de usuarios
    @GET("listarUsuarios")//busca usuarios/listarUsuarios en el URL del servicio
    Call<List<Usuario>> getUsuario();

    //Post para el login
    @FormUrlEncoded
    @POST("login")
    Call<Usuario> LoginUsuario(@Field("user") String user,@Field("pass") String pass);

}
