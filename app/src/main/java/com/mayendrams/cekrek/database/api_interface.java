package com.mayendrams.cekrek.database;

import com.mayendrams.cekrek.model.ModelLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface api_interface {

    @FormUrlEncoded
    @POST("Login.php")
    Call<ModelLogin> login(@Field("email") String email, @Field("password") String password);
}
