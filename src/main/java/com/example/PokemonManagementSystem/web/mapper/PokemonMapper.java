package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // This allows Spring to manage the mapper as a bean
public interface PokemonMapper {
    PokemonDto toDto(Pokemon pokemon);
    Pokemon toModel(PokemonDto dto);
}
