package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Stats;
import com.example.PokemonManagementSystem.web.dto.StatsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatsMapper {

    StatsDto toDto(Stats stats);
    Stats toModel(StatsDto statsDto);
}
