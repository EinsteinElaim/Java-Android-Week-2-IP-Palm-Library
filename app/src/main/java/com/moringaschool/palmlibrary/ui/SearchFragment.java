package com.moringaschool.palmlibrary.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.palmlibrary.R;


public class SearchFragment extends Fragment {


//    @BindView(R.id.buttonSearchLibrary) Button  mButtonSearchLibrary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ButterKnife.bind(getActivity());



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        Button button = (Button) rootView.findViewById(R.id.buttonSearchLibrary);
        EditText editTextSearchWord = (EditText) rootView.findViewById(R.id.editTextSearchLibrary);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookListActivity.class);
                String searchText = editTextSearchWord.getText().toString();
                intent.putExtra("searchText", searchText);
                getActivity().startActivity(intent);
            }
        });

        return rootView;

//            Button mButtonSearchLibrary = (Button) getView().findViewById(R.id.buttonSearchLibrary);
//            mButtonSearchLibrary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), BookListActivity.class);
//                ((MainActivity) getActivity()).startActivity(intent);
//            }
//        });



        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}