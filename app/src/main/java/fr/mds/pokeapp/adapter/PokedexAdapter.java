package fr.mds.pokeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.mds.pokeapp.PokemonActivity;
import fr.mds.pokeapp.R;
import fr.mds.pokeapp.model.Pokedex;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {

    private ImageView img_pokemon;
    private TextView tv_pokemon;

    // Provide a direct reference to each of the views within a data item
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

            img_pokemon = (ImageView) itemView.findViewById(R.id.img_pokemon);
            tv_pokemon = (TextView) itemView.findViewById(R.id.tv_pokemon);
        }
    }

    // Store a member variable for the pokemon
    private List<Pokedex> mPokemons;

    // Pass in the pokedex array into the constructor
    public PokedexAdapter(List<Pokedex> pokemons) {
        mPokemons = pokemons;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PokedexAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View pokedexView = inflater.inflate(R.layout.item_pokemon, parent, false);
        pokedexView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PokemonActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(pokedexView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PokedexAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Pokedex pokedex = mPokemons.get(position);

        // Set item views based on your views and data model
        Picasso.get().load(pokedex.getSprite()).into(img_pokemon);
        tv_pokemon.setText(pokedex.getName());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

}
