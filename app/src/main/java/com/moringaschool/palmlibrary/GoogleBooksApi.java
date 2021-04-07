package com.moringaschool.palmlibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksApi {
    @GET("volumes")
    Call<GoogleBooksSearchResponse> getBooks(
            @Query("q") String title,
            @Query("term") String term
    );
}
