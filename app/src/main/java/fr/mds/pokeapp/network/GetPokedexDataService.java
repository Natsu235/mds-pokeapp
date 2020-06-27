package fr.mds.pokeapp.network;

import java.util.List;

import fr.mds.pokeapp.model.Pokedex;
import fr.mds.pokeapp.model.PokedexResult;
import fr.mds.pokeapp.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPokedexDataService {

    // Get Pokedex
    @GET("pokemon?offset=0&limit=964")
    Call<Pokedex> getPokedex();

    // Get Pokemon
    @GET("pokemon/{name}")
    Call<Pokemon> getPokemon();

}
