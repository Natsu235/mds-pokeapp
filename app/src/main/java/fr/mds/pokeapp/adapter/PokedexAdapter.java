package fr.mds.pokeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import fr.mds.pokeapp.model.PokedexResults;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.CustomViewHolder> {

    private List<PokedexResults> pokemonList;
    private Context context;
    private Drawable decamarkSprite;

    public PokedexAdapter(Context context, List<PokedexResults> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
        this.decamarkSprite = context.getResources().getDrawable(R.drawable.decamark);
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
        final View pokemonView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        final CustomViewHolder holder = new CustomViewHolder(pokemonView);

        holder.setIsRecyclable(false);
        pokemonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(), PokemonActivity.class);
                intent.putExtra("pokemonName", pokemonList.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Integer pokemonId = pokemonList.get(position).getId();
        String pokemonName = pokemonList.get(position).getName();
        String pokemonSprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonId + ".png";

        holder.tv_pokemon_id.setText("#" + String.format("%03d", pokemonId));
        holder.tv_pokemon_name.setText(pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1));
        Picasso.get().load(pokemonSprite).placeholder(decamarkSprite).error(decamarkSprite).into(holder.img_pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

}
