package xyz.gaborohez.starwarsencyclopedia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import xyz.gaborohez.starwarsencyclopedia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_StarWarsEncyclopedia);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setFragment();
    }

    private void setFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentLayout, HomeFragment.newInstance(), HomeFragment.class.getName())
                .commit();
    }
}