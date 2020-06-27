package fr.mds.pokeapp.network;

import fr.mds.pokeapp.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetPokemonDataService {

    // Get Pokemon
    @GET("pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);

}
