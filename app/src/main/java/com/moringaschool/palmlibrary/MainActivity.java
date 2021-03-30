package com.moringaschool.palmlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moringaschool.palmlibrary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        BottomNavigationView bottomNav = binding.bottomNav;

        openFragment(new HomeFragment());



        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        openFragment(new HomeFragment());
                        return true;

                    case R.id.search:
                        openFragment(new SearchFragment());
                        return true;

                    case R.id.account:
                        openFragment(new AccountFragment());
                        return true;

                    case R.id.saved:
                        openFragment(new SavedFragment());
                        return true;

                    case R.id.about:
                        openFragment(new AboutFragment());
                        return true;


                }


                return false;
            }
        });

    }

    void openFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
