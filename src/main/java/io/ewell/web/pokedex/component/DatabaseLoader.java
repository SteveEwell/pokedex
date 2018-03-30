package io.ewell.web.pokedex.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import io.ewell.web.pokedex.model.PokemonRepository;
import io.ewell.web.pokedex.model.Pokemon;
import io.ewell.web.pokedex.model.PokemonType;
import io.ewell.web.pokedex.model.PokemonTypeRepository;

import java.util.Map;
import java.util.HashMap;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;
    private final PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public DatabaseLoader(PokemonRepository pokemonRepository, PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Map<String, PokemonType> pokemonTypes = new HashMap<String, PokemonType>();

        pokemonTypes.put("Normal", new PokemonType("Normal"));
        pokemonTypes.put("Fire", new PokemonType("Fire"));
        pokemonTypes.put("Water", new PokemonType("Water"));
        pokemonTypes.put("Electric", new PokemonType("Electric"));
        pokemonTypes.put("Grass", new PokemonType("Grass"));
        pokemonTypes.put("Ice", new PokemonType("Ice"));
        pokemonTypes.put("Fighting", new PokemonType("Fighting"));
        pokemonTypes.put("Poison", new PokemonType("Poison"));
        pokemonTypes.put("Ground", new PokemonType("Ground"));
        pokemonTypes.put("Flying", new PokemonType("Flying"));
        pokemonTypes.put("Psychic", new PokemonType("Psychic"));
        pokemonTypes.put("Bug", new PokemonType("Bug"));
        pokemonTypes.put("Rock", new PokemonType("Rock"));
        pokemonTypes.put("Ghost", new PokemonType("Ghost"));
        pokemonTypes.put("Dragon", new PokemonType("Dragon"));
        pokemonTypes.put("Dark", new PokemonType("Dark"));
        pokemonTypes.put("Steel", new PokemonType("Steel"));
        pokemonTypes.put("Fairy", new PokemonType("Fairy"));

        for(PokemonType typ : pokemonTypes.values()) {
            pokemonTypeRepository.save(typ);
        }

        Pokemon poke1 = new Pokemon(
                1,
                "Bulbasaur",
                "Seed Pokemon",
                0.71,
                6.9,
                "A strange seed was planted on its back at birth. The plant sprouts and grows with this POKéMON."
        );

        Pokemon poke2 = new Pokemon(
                2,
                "Ivysaur",
                "Seed Pokemon",
                0.99,
                13.0,
                "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."
        );

        Pokemon poke3 = new Pokemon(
                3,
                "Venusaur",
                "Seed Pokemon",
                2.01,
                100.0,
                "The plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight."
        );

        poke1.getType().add(pokemonTypes.get("Grass"));
        poke1.getType().add(pokemonTypes.get("Poison"));
        this.pokemonRepository.save(poke1);

        poke2.getType().add(pokemonTypes.get("Grass"));
        poke2.getType().add(pokemonTypes.get("Poison"));
        this.pokemonRepository.save(poke2);

        poke3.getType().add(pokemonTypes.get("Grass"));
        poke3.getType().add(pokemonTypes.get("Poison"));
        this.pokemonRepository.save(poke3);
    }
}
