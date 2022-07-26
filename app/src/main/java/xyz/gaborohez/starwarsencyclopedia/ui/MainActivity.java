package xyz.gaborohez.starwarsencyclopedia.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import xyz.gaborohez.starwarsencyclopedia.R;
import xyz.gaborohez.starwarsencyclopedia.databinding.ActivityMainBinding;
import xyz.gaborohez.starwarsencyclopedia.ui.home.view.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_StarWarsEncyclopedia);
        super.onCreate(savedInstanceState);
        xyz.gaborohez.starwarsencyclopedia.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        setFragment();
    }

    private void setFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentLayout, HomeFragment.newInstance(), HomeFragment.class.getName())
                .commit();
    }
}