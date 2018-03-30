package io.ewell.web.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.ewell.web.pokedex.model.Pokemon;
import io.ewell.web.pokedex.service.PokemonService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping(value = "/pokemon", method = RequestMethod.GET)
    public List getAllPokemon() {

        return pokemonService.getAllPokemon();

    }

    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.GET)
    public Optional<Pokemon> getPokemon(@PathVariable Integer id) {
        return pokemonService.getPokemon(id);
    }

    @RequestMapping(value = "/pokemon", method = RequestMethod.POST)
    public void addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);

    }

    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.PUT)
    public void updatePokemon(@RequestBody Pokemon pokemon, @PathVariable Integer id) {
        pokemonService.updatePokemon(pokemon);
    }

    @RequestMapping(value = "/pokemon/{id}", method = RequestMethod.DELETE)
    public void deletePokemon(@PathVariable Integer id) {
        pokemonService.deletePokemon(id);
    }
}
