package fr.mds.pokeapp.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class PokedexResult implements Serializable
{
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public PokedexResult() {
    }

    public PokedexResult(String name, String url) {
        this.name = name;
        this.url = url;
    }

    // Getters
    public String getName() { return name; }
    public String getUrl() { return url; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }

}