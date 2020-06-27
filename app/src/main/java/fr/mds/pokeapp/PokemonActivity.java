package fr.mds.pokeapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import fr.mds.pokeapp.model.Pokemon;
import fr.mds.pokeapp.model.PokemonSprites;
import fr.mds.pokeapp.network.GetPokemonDataService;
import fr.mds.pokeapp.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity {

    private ProgressBar sp_pokemon;
    private TextView tv_pokemon_id;
    private TextView tv_pokemon_name;
    private TextView tv_pokemon_base_exp;
    private TextView tv_pokemon_height;
    private TextView tv_pokemon_weight;
    private ImageView img_pokemon_back_default;
    private ImageView img_pokemon_back_female;
    private ImageView img_pokemon_back_shiny;
    private ImageView img_pokemon_back_shiny_female;
    private ImageView img_pokemon_front_default;
    private ImageView img_pokemon_front_female;
    private ImageView img_pokemon_front_shiny;
    private ImageView img_pokemon_front_shiny_female;
    private Drawable decamarkSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("pokemonName");

        sp_pokemon = (ProgressBar) findViewById(R.id.sp_pokemon);
        sp_pokemon.setVisibility(View.VISIBLE);
        tv_pokemon_id = (TextView) findViewById(R.id.tv_pokemon_id);
        tv_pokemon_name = (TextView) findViewById(R.id.tv_pokemon_name);
        tv_pokemon_base_exp = (TextView) findViewById(R.id.tv_pokemon_base_exp);
        tv_pokemon_height = (TextView) findViewById(R.id.tv_pokemon_height);
        tv_pokemon_weight = (TextView) findViewById(R.id.tv_pokemon_weight);
        img_pokemon_back_default = (ImageView) findViewById(R.id.img_pokemon_back_default);
        img_pokemon_back_female = (ImageView) findViewById(R.id.img_pokemon_back_female);
        img_pokemon_back_shiny = (ImageView) findViewById(R.id.img_pokemon_back_shiny);
        img_pokemon_back_shiny_female = (ImageView) findViewById(R.id.img_pokemon_back_shiny_female);
        img_pokemon_front_default = (ImageView) findViewById(R.id.img_pokemon_front_default);
        img_pokemon_front_female = (ImageView) findViewById(R.id.img_pokemon_front_female);
        img_pokemon_front_shiny = (ImageView) findViewById(R.id.img_pokemon_front_shiny);
        img_pokemon_front_shiny_female = (ImageView) findViewById(R.id.img_pokemon_front_shiny_female);
        decamarkSprite = PokemonActivity.this.getResources().getDrawable(R.drawable.decamark);

        GetPokemonDataService service = RetrofitInstance.getRetrofitInstance().create(GetPokemonDataService.class);
        Call<Pokemon> call = service.getPokemon(pokemonName);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                generateData(response.body());
                sp_pokemon.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(PokemonActivity.this, "Something went wrong... Please try again later.", Toast.LENGTH_SHORT).show();
                sp_pokemon.setVisibility(View.GONE);
            }
        });
    }

    // Fill PokemonView with response data
    private void generateData(Pokemon pokemon) {
        Integer pokemonId = pokemon.getId();
        String pokemonName = pokemon.getName();
        Integer pokemonBaseExp = pokemon.getBaseExperience();
        Integer pokemonHeight = pokemon.getHeight();
        Integer pokemonWeight = pokemon.getWeight();
        PokemonSprites pokemonSprites = pokemon.getSprites();

        tv_pokemon_id.setText(String.format("%03d", pokemonId));
        tv_pokemon_name.setText(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        tv_pokemon_base_exp.setText(Integer.toString(pokemonBaseExp));
        tv_pokemon_height.setText(Integer.toString(pokemonHeight));
        tv_pokemon_weight.setText(Integer.toString(pokemonWeight));
        Picasso.get().load(pokemonSprites.getBackDefault()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_back_default);
        Picasso.get().load(pokemonSprites.getBackFemale()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_back_female);
        Picasso.get().load(pokemonSprites.getBackShiny()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_back_shiny);
        Picasso.get().load(pokemonSprites.getBackShinyFemale()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_back_shiny_female);
        Picasso.get().load(pokemonSprites.getFrontDefault()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_front_default);
        Picasso.get().load(pokemonSprites.getFrontFemale()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_front_female);
        Picasso.get().load(pokemonSprites.getFrontShiny()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_front_shiny);
        Picasso.get().load(pokemonSprites.getFrontShinyFemale()).placeholder(decamarkSprite).error(decamarkSprite).into(img_pokemon_front_shiny_female);
    }

    // Show Sprite View
    public void showSprite(View view) {
        Intent intent = new Intent(this, SpriteActivity.class);
        startActivity(intent);
    }

}
