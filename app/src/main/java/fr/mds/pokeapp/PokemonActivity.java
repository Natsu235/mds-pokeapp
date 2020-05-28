package fr.mds.pokeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
    }

}
