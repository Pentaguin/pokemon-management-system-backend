package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PokemonMapper {
    PokemonDto toDto(Pokemon pokemon);
    Pokemon toModel(PokemonDto pokemonDto);
    List<PokemonDto> toDtoList(List<Pokemon> pokemon);
}
