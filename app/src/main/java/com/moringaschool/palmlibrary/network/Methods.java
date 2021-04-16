package com.moringaschool.palmlibrary.network;

import com.moringaschool.palmlibrary.models.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Methods {

    @GET("volumes")
    Call<Model> getItems(
        @Query("q") String searchBook
    );
}
