package fr.mds.pokeapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PokemonSprites implements Serializable {

    private final String MISSINGNO_SPRITE = "https://www.pokepedia.fr/images/5/54/Sprite_MissingNo._RV.png";
    private final String DECAMARK_SPRITE = "https://www.pokepedia.fr/images/f/f7/Sprite_%3F%3F%3F%3F%3F%3F%3F%3F%3F%3F_RS.png";

    @SerializedName("back_default")
    private String back_default;
    @SerializedName("back_female")
    private String back_female;
    @SerializedName("back_shiny")
    private String back_shiny;
    @SerializedName("back_shiny_female")
    private String back_shiny_female;
    @SerializedName("front_default")
    private String front_default;
    @SerializedName("front_female")
    private String front_female;
    @SerializedName("front_shiny")
    private String front_shiny;
    @SerializedName("front_shiny_female")
    private String front_shiny_female;

    public PokemonSprites() {
    }

    public PokemonSprites(String back_default, String back_female, String back_shiny, String back_shiny_female, String front_default, String front_female, String front_shiny, String front_shiny_female) {
        this.back_default = back_default;
        this.back_female = back_female;
        this.back_shiny = back_shiny;
        this.back_shiny_female = back_shiny_female;
        this.front_default = front_default;
        this.front_female = front_female;
        this.front_shiny = front_shiny;
        this.front_shiny_female = front_shiny_female;
    }

    // Getters
    public String getBackDefault() { return back_default; }
    public String getBackFemale() { return back_female; }
    public String getBackShiny() { return back_shiny; }
    public String getBackShinyFemale() { return back_shiny_female; }
    public String getFrontDefault() { return front_default; }
    public String getFrontFemale() { return front_female; }
    public String getFrontShiny() { return front_shiny; }
    public String getFrontShinyFemale() { return front_shiny_female; }

    // Setters
    public void setBackDefault(String back_default) { this.back_default = back_default; }
    public void setBackFemale(String back_female) { this.back_female = back_female; }
    public void setBackShiny(String back_shiny) { this.back_shiny = back_shiny; }
    public void setBackShinyFemale(String back_shiny_female) { this.back_shiny_female = back_shiny_female; }
    public void setFrontDefault(String front_default) { this.front_default = front_default; }
    public void setFrontFemale(String front_female) { this.front_female = front_female; }
    public void setFrontShiny(String front_shiny) { this.front_shiny = front_shiny; }
    public void setFrontShinyFemale(String front_shiny_female) { this.front_shiny_female = front_shiny_female; }

}
