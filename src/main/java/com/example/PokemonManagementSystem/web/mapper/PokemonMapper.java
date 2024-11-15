package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PokemonMapper {
    PokemonDto toDto(Pokemon pokemon);
    Pokemon toModel(PokemonDto pokemonDto);
}
