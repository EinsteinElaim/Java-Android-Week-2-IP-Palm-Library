package com.moringaschool.palmlibrary.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.palmlibrary.Constants.key;
import static com.moringaschool.palmlibrary.Constants.GOOGLE_BOOKS_BASE_URL;

import java.io.IOException;

public class RetrofitClient {

    private static Retrofit retrofit;
    public static Methods getClient(){
        if (retrofit == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("key", key)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    }).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(GOOGLE_BOOKS_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Methods.class);
    }



}
