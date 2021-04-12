package com.moringaschool.palmlibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.moringaschool.palmlibrary.*;
import com.moringaschool.palmlibrary.models.Model;
import com.moringaschool.palmlibrary.network.Methods;
import com.moringaschool.palmlibrary.network.RetrofitClient;

public class BookListActivity extends AppCompatActivity {

    private final String TAG = "BookListActivity";
    private Button getData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Intent intent = getIntent();
        String searchText = intent.getExtras().getString("searchText");

        Methods client = RetrofitClient.getClient();

        Log.d(TAG, "In the On create method");

        Call<Model> call = client.getItems(searchText);


        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                if (response.isSuccessful()){
                    Log.d(TAG, response.toString());
                    TextView textViewTotalData = (TextView) findViewById(R.id.editTextResultsTotal);
                    textViewTotalData.setText(response.toString());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }
}