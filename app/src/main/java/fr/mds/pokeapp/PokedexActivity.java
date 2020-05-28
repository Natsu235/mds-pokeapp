package fr.mds.pokeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PokedexActivity extends AppCompatActivity {

    private RecyclerView rv_pokedex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        rv_pokedex = findViewById(R.id.rv_pokedex);
    }

}
