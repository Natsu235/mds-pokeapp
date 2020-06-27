package fr.mds.pokeapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pokemon implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("base_experience")
    private Integer base_experience;
    @SerializedName("height")
    private Integer height;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("sprites")
    private PokemonSprites sprites;

    public Pokemon() {
    }

    public Pokemon(Integer id, String name, Integer base_experience, Integer height, Integer weight, PokemonSprites sprites) {
        this.id = id;
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
        this.weight = weight;
        this.sprites = sprites;
    }

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getBaseExperience() { return base_experience; }
    public Integer getHeight() { return height; }
    public Integer getWeight() { return weight; }
    public PokemonSprites getSprites() { return sprites; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBaseExperience(Integer base_experience) { this.base_experience = base_experience; }
    public void setHeight(Integer height) { this.height = height; }
    public void setWeight(Integer weight) { this.weight = weight; }
    public void setSprites(PokemonSprites sprites) { this.sprites = sprites; }

}
