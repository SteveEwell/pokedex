package io.ewell.web.pokedex.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    private Integer id;
    private Integer number;
    private String name;
    private String species;
    private Double height;
    private Double weight;
    private String description;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "pokemon_pokemon_type",
            joinColumns = { @JoinColumn(name = "pokemon_id") },
            inverseJoinColumns = { @JoinColumn(name = "pokemon_type_id") }
    )
    private Set<PokemonType> type = new HashSet<>();

    public Pokemon() {}

    public Pokemon(Integer number, String name, String species, Double height, Double weight, String description) {
        this.id = number;
        this.number = number;
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public Pokemon(Integer id, Integer number, String name, String species, Double height, Double weight, String description) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PokemonType> getType() {
        return type;
    }

    public void setType(Set<PokemonType> type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(number,pokemon.number) &&
                Objects.equals(id, pokemon.id) &&
                Objects.equals(name, pokemon.name) &&
                Objects.equals(species, pokemon.species) &&
                Objects.equals(height, pokemon.height) &&
                Objects.equals(weight, pokemon.weight) &&
                Objects.equals(description, pokemon.description) &&
                Objects.equals(type, pokemon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, species, height, weight, description);
    }
}
