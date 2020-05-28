package fr.mds.pokeapp.model;

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

    // Getters
    public int getId() { return id; }
    public String getSprite() { return sprite; }
    public String getName() { return name; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setSprite(String sprite) { this.sprite = sprite; }
    public void setName(String name) { this.name = name; }

}
