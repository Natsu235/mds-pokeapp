package fr.mds.pokeapp.network;

import fr.mds.pokeapp.model.Pokedex;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPokedexDataService {

    // Get Pokedex
    @GET("pokemon?offset=0&limit=964")
    Call<Pokedex> getPokedex();

}
