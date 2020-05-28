package fr.mds.pokeapp.model;

public class Pokemon {

    private int id;
    private String name;
    private int base_experience;
    private int height;

    public Pokemon() {
    }

    public Pokemon(int id, String name, int base_experience, int height) {
        this.id = id;
        this.name = name;
        this.base_experience = base_experience;
        this.height = height;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getBaseExperience() { return base_experience; }
    public int getHeight() { return height; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBaseExperience(int base_experience) { this.base_experience = base_experience; }
    public void setHeight(int height) { this.height = height; }

}
