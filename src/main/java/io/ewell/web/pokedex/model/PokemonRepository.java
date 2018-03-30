package io.ewell.web.pokedex.model;

import org.springframework.data.repository.CrudRepository;


public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

}
