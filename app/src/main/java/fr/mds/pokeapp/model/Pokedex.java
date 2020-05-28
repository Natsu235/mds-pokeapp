package fr.mds.pokeapp.model;

import java.util.ArrayList;

public class Pokedex {

    private int id;
    private String sprite;
    private String name;

    public Pokedex() {
    }

    public Pokedex(int id, String sprite, String name) {
        this.id = id;
        this.sprite = sprite;
        this.name = name;
    }

    public static ArrayList<Pokedex> createPokedexList(int numPokemons) {
        ArrayList<Pokedex> pokemons = new ArrayList<Pokedex>();
        int pokemonId = 0;

        for (int i = 1; i <= numPokemons; i++) {
            pokemons.add(new Pokedex(pokemonId, "https://vignette.wikia.nocookie.net/envision/images/b/b7/Missingno.png/revision/latest?cb=20200111070311", "Pokémon #" + String.format("%03d", pokemonId)));
            pokemonId++;
        }

        pokemonId = 0;
        return pokemons;
    }

    // Getters
    public int getId() { return id; }
    public String getSprite() { return sprite; }
    public String getName() { return name; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setSprite(String sprite) { this.sprite = sprite; }
    public void setName(String name) { this.name = name; }

}
