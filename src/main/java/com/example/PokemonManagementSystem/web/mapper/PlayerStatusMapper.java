package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerStatusMapper {

    PlayerStatusDto toDto(PlayerStatus playerStatus);
    PlayerStatus toModel(PlayerStatusDto playerStatusDto);
}
