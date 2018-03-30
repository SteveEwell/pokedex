package io.ewell.web.pokedex.service;

import io.ewell.web.pokedex.model.Pokemon;
import io.ewell.web.pokedex.model.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List getAllPokemon() {

        List pokemon = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemon::add);

        return pokemon;
    }

    public Optional<Pokemon> getPokemon(Integer id) {
        return pokemonRepository.findById(id);

    }

    public void addPokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
