package com.moringaschool.palmlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SearchResultsActivity extends AppCompatActivity {

    private ListView mListViewTitle;
//    private ListView mListViewGenre;
    private TextView mTextViewSearchResultsTitle;

    String[] titles = new String[] {
            "Diary of Anne Frank", "Atlas", "Betty Crocker Cookbook", "The Sun Also Rises", "To Kill A Mockingbird"
            , "Killing England", "A Confederacy of Dunes", "The 7 Habits of Highly Effective People"
    };
    String[] genres = new String[] {
            "Non fiction - Journal", "Non fiction - Atlas", "Factual - Food", "Fiction", "Fiction",
            "Non fiction - History", "Non fiction - Politics", "Self Help"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

//        mTextViewSearchResultsTitle = (TextView) findViewById(R.id.searchResultText);


        mListViewTitle = (ListView) findViewById(R.id.listViewTitle);
//        mListViewGenre = (ListView) findViewById(R.id.listViewGenre);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        mListViewTitle.setAdapter(adapter);

        mListViewTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = ((TextView) view).getText().toString();
                Toast.makeText(SearchResultsActivity.this, title, Toast.LENGTH_LONG).show();
            }
        });

//        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_2, genres);
//        mListViewGenre.setAdapter(adapter1);
//
//        mListViewGenre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String genre = ((TextView) view).getText().toString();
//                Toast.makeText(SearchResultsActivity.this, genre, Toast.LENGTH_LONG).show();
//            }
//        });



        Intent intent = getIntent();
        String searchedText = intent.getExtras().getString("searchText");
        Log.d("IntentExtraSearchResultCaught", searchedText);
//        mTextViewSearchResultsTitle.setText(searchedText);

    }
}