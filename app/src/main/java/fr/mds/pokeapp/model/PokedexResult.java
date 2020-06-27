package fr.mds.pokeapp.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class PokedexResult implements Serializable
{
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public PokedexResult() {
    }

    public PokedexResult(String name, String url) {
        this.id = Integer.parseInt(url.substring(34, url.length() - 1));
        this.name = name;
        this.url = url;
    }

    // Getters
    public Integer getId() { return Integer.parseInt(url.substring(34, url.length() - 1)); }
    public String getName() { return name; }
    public String getUrl() { return url; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }

}
