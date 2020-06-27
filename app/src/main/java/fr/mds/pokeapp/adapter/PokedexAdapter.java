package fr.mds.pokeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import fr.mds.pokeapp.R;
import fr.mds.pokeapp.model.PokedexResult;

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
        private TextView tv_pokemon;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            img_pokemon = mView.findViewById(R.id.img_pokemon);
            tv_pokemon = mView.findViewById(R.id.tv_pokemon);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tv_pokemon.setText(pokemonList.get(position).getName());

        Picasso.Builder builder = new Picasso.Builder(context);
        Picasso.get().load("https://vignette.wikia.nocookie.net/envision/images/b/b7/Missingno.png/revision/latest?cb=20200111070311").into(holder.img_pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

}
