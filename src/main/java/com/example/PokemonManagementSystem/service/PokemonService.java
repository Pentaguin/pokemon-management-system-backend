package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.repository.PokemonRepository;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import com.example.PokemonManagementSystem.web.transformer.PokemonTransformer;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final PokemonTransformer pokemonTransformer;

    private PokemonService(PokemonRepository pokemonRepository, PokemonTransformer pokemonTransformer){
        this.pokemonRepository = pokemonRepository;
        this.pokemonTransformer = pokemonTransformer;
    }

    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = pokemonTransformer.toModel(pokemonDto);
        Pokemon savedPokemon = pokemonRepository.save(pokemon);
        return pokemonTransformer.toDto(savedPokemon);
    }
}
