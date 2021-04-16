package com.moringaschool.palmlibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.moringaschool.palmlibrary.*;
import com.moringaschool.palmlibrary.models.Item;
import com.moringaschool.palmlibrary.models.Model;
import com.moringaschool.palmlibrary.network.Methods;
import com.moringaschool.palmlibrary.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private Button getData;
    private static final String TAG = BookListActivity.class.getSimpleName();
//    @BindView(R.id.editTextResultsTotal) TextView mEditTextResultsTotal;
   private ListView mListView;

    private String[] books = new String[] {"First Book", "Second Book",
            "Third Book", "Fourth Book", "Fifth Book", "Sixth Book",
            "Seventh Book", "Eighth  Book", "Ninth Book", "Tenth Book"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        mListView = (ListView) findViewById(R.id.booksListView);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(BookListActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String searchText = intent.getExtras().getString("searchBook");

        Methods client = RetrofitClient.getClient();

        Log.d(TAG, "In the On create method");

        Call<Model> call = client.getItems(searchText);


        call.enqueue(new Callback<Model>() {

            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {


                if (response.isSuccessful()){
                    Log.d(TAG, response.toString());
                } else {
                    Log.d("Failed! : ", "Failed to connect to API!");
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });

    }
}