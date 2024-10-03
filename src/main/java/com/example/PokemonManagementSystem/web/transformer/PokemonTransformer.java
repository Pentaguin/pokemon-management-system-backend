package com.example.PokemonManagementSystem.web.transformer;

import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.springframework.stereotype.Component;

@Component
public class PokemonTransformer {
    public PokemonDto toDto(Pokemon pokemon) {
        PokemonDto dto = new PokemonDto();
        dto.setPokeApiId(pokemon.getPokeApiId());
        dto.setName(pokemon.getName());
        dto.setImageUrl(pokemon.getImageUrl());
        dto.setType(pokemon.getType());
        dto.setGeneration(pokemon.getGeneration());
        return dto;
    }

    public Pokemon toModel(PokemonDto dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setPokeApiId(dto.getPokeApiId());
        pokemon.setName(dto.getName());
        pokemon.setImageUrl(dto.getImageUrl());
        pokemon.setType(dto.getType());
        pokemon.setGeneration(dto.getGeneration());
        return pokemon;
    }
}
