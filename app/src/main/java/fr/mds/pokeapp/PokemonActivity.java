package fr.mds.pokeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
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

    private TextView tv_pokemon_id;
    private TextView tv_pokemon_name;
    private TextView tv_pokemon_base_exp;
    private TextView tv_pokemon_height;
    private ImageView img_pokemon_back_default;
    private ImageView img_pokemon_back_female;
    private ImageView img_pokemon_back_shiny;
    private ImageView img_pokemon_back_shiny_female;
    private ImageView img_pokemon_front_default;
    private ImageView img_pokemon_front_female;
    private ImageView img_pokemon_front_shiny;
    private ImageView img_pokemon_front_shiny_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("pokemonName");

        tv_pokemon_id = (TextView) findViewById(R.id.tv_pokemon_id);
        tv_pokemon_name = (TextView) findViewById(R.id.tv_pokemon_name);
        tv_pokemon_base_exp = (TextView) findViewById(R.id.tv_pokemon_base_exp);
        img_pokemon_back_default = (ImageView) findViewById(R.id.img_pokemon_back_default);
        img_pokemon_back_female = (ImageView) findViewById(R.id.img_pokemon_back_female);
        img_pokemon_back_shiny = (ImageView) findViewById(R.id.img_pokemon_back_shiny);
        img_pokemon_back_shiny_female = (ImageView) findViewById(R.id.img_pokemon_back_shiny_female);
        img_pokemon_front_default = (ImageView) findViewById(R.id.img_pokemon_front_default);
        img_pokemon_front_female = (ImageView) findViewById(R.id.img_pokemon_front_female);
        img_pokemon_front_shiny = (ImageView) findViewById(R.id.img_pokemon_front_shiny);
        img_pokemon_front_shiny_female = (ImageView) findViewById(R.id.img_pokemon_front_shiny_female);

        GetPokemonDataService service = RetrofitInstance.getRetrofitInstance().create(GetPokemonDataService.class);
        Call<Pokemon> call = service.getPokemon(pokemonName);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                generateData(response.body());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(PokemonActivity.this, "Something went wrong... Please try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateData(Pokemon pokemon) {
        Integer pokemonId = pokemon.getId();
        String pokemonName = pokemon.getName();
        Integer pokemonBaseExp = pokemon.getBaseExperience();
        Integer pokemonHeight = pokemon.getHeight();
        PokemonSprites pokemonSprites = pokemon.getSprites();
        String missingNoSprite = "https://www.pokepedia.fr/images/5/54/Sprite_MissingNo._RV.png";
        String decamarkSprite = "https://www.pokepedia.fr/images/f/f7/Sprite_%3F%3F%3F%3F%3F%3F%3F%3F%3F%3F_RS.png";

        tv_pokemon_id.setText(String.format("%03d", pokemonId));
        tv_pokemon_name.setText(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        tv_pokemon_base_exp.setText(Integer.toString(pokemonBaseExp));
        //tv_pokemon_height.setText(Integer.toString(pokemonHeight));    // It doesn't works for some reason...
        Picasso.get().load(pokemonSprites.getBackDefault() != null ? pokemonSprites.getBackDefault() : decamarkSprite).into(img_pokemon_back_default);
        Picasso.get().load(pokemonSprites.getBackDefault() == null ? decamarkSprite : (pokemonSprites.getBackFemale() != null ? pokemonSprites.getBackFemale() : pokemonSprites.getBackDefault())).into(img_pokemon_back_female);
        Picasso.get().load(pokemonSprites.getBackShiny() != null ? pokemonSprites.getBackShiny() : decamarkSprite).into(img_pokemon_back_shiny);
        Picasso.get().load(pokemonSprites.getBackShiny() == null ? decamarkSprite : (pokemonSprites.getBackShinyFemale() != null ? pokemonSprites.getBackShinyFemale() : pokemonSprites.getBackShiny())).into(img_pokemon_back_shiny_female);
        Picasso.get().load(pokemonSprites.getFrontDefault() != null ? pokemonSprites.getFrontDefault() : decamarkSprite).into(img_pokemon_front_default);
        Picasso.get().load(pokemonSprites.getFrontDefault() == null ? decamarkSprite : (pokemonSprites.getFrontFemale() != null ? pokemonSprites.getFrontFemale() : pokemonSprites.getFrontDefault())).into(img_pokemon_front_female);
        Picasso.get().load(pokemonSprites.getFrontShiny() != null ? pokemonSprites.getFrontShiny() : decamarkSprite).into(img_pokemon_front_shiny);
        Picasso.get().load(pokemonSprites.getFrontShiny() == null ? decamarkSprite : (pokemonSprites.getFrontShinyFemale() != null ? pokemonSprites.getFrontShinyFemale() : pokemonSprites.getFrontShiny())).into(img_pokemon_front_shiny_female);
    }

}
