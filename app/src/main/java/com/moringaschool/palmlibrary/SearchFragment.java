package com.moringaschool.palmlibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class SearchFragment extends Fragment {
    Intent intent;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
        EditText searchText = (EditText) view.findViewById(R.id.editTextSearchLibrary);
        String search = searchText.getText().toString();
        Button searchLibrary = (Button) view.findViewById(R.id.buttonSearchLibrary);

        searchLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchFragment.super.getActivity(), SearchResultsActivity.class);
//                i.putExtra("searchText", search);
//                Log.d("SearchBtnClicked", search);
                startActivity(i);
            }
        });


        return view;
//        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}