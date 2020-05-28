package fr.mds.pokeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.mds.pokeapp.adapter.PokedexAdapter;
import fr.mds.pokeapp.model.Pokedex;

public class PokedexActivity extends AppCompatActivity {

    private RecyclerView rv_pokedex;
    ArrayList<Pokedex> pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        // Lookup the recyclerview in activity layout
        rv_pokedex = (RecyclerView) findViewById(R.id.rv_pokedex);

        // Initialize pokedex
        pokemons = Pokedex.createPokedexList(200);
        // Create adapter passing in the sample user data
        PokedexAdapter adapter = new PokedexAdapter(pokemons);
        // Attach the adapter to the recyclerview to populate items
        rv_pokedex.setAdapter(adapter);
        // Set layout manager to position the items
        rv_pokedex.setLayoutManager(new LinearLayoutManager(this));
    }

    // Show Pokémon View
    public void showPokemon(View view) {
        Intent intent = new Intent(this, PokemonActivity.class);
        startActivity(intent);
    }

}
