package fr.mds.pokeapp.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Pokedex implements Serializable {

    @SerializedName("count")
    private Integer count;
    @SerializedName("next")
    private Integer next;
    @SerializedName("previous")
    private Integer previous;
    @SerializedName("results")
    private List<PokedexResults> results;

    public Pokedex() {
    }

    public Pokedex(Integer count, Integer next, Integer previous, List<PokedexResults> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    // Getters
    public Integer getCount() { return count; }
    public Integer getNext() { return next; }
    public Integer getPrevious() { return previous; }
    public List<PokedexResults> getResults() { return results; }

    // Setters
    public void setCount(Integer count) { this.count = count; }
    public void setNext(Integer next) { this.next = next; }
    public void setPrevious(Integer previous) { this.previous = previous; }
    public void setResults(List<PokedexResults> results) { this.results = results; }

}
