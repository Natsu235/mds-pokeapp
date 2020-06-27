package fr.mds.pokeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import fr.mds.pokeapp.PokedexActivity;
import fr.mds.pokeapp.PokemonActivity;
import fr.mds.pokeapp.R;
import fr.mds.pokeapp.model.Pokedex;
import fr.mds.pokeapp.model.PokedexResult;
import fr.mds.pokeapp.model.Pokemon;
import fr.mds.pokeapp.model.PokemonSprite;
import fr.mds.pokeapp.network.GetPokedexDataService;
import fr.mds.pokeapp.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.CustomViewHolder> {

    private List<PokedexResult> pokemonList;
    private Context context;

    public PokedexAdapter(Context context, List<PokedexResult> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        private ImageView img_pokemon;
        private TextView tv_pokemon_id;
        private TextView tv_pokemon_name;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            img_pokemon = mView.findViewById(R.id.img_pokemon);
            tv_pokemon_id = mView.findViewById(R.id.tv_pokemon_id);
            tv_pokemon_name = mView.findViewById(R.id.tv_pokemon_name);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View pokemonView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        pokemonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PokemonActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return new CustomViewHolder(pokemonView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Integer pokemonId = pokemonList.get(position).getId();
        String pokemonName = pokemonList.get(position).getName();

        holder.tv_pokemon_id.setText(String.format("%03d", pokemonId));
        holder.tv_pokemon_name.setText(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonId + ".png").into(holder.img_pokemon);

        //GetPokedexDataService service = RetrofitInstance.getRetrofitInstance().create(GetPokedexDataService.class);
        //Call<Pokemon> call = service.getPokemon(pokemonName);
        //call.enqueue(new Callback<Pokemon>() {
        //    @Override
        //    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
        //        PokemonSprite pokemonSprites = response.body().getSprites();
        //        Picasso.get().load(pokemonSprites.getFrontDefault()).into(img_pokemon);
        //    }

        //    @Override
        //    public void onFailure(Call<Pokemon> call, Throwable t) {
        //        t.printStackTrace();
        //        Toast.makeText(context, "Something went wrong... Please try again later.", Toast.LENGTH_SHORT).show();
        //    }
        //});
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

}
