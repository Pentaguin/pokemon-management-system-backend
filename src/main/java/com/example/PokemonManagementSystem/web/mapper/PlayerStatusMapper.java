package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.web.dto.PlayerStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerStatusMapper {
    PlayerStatusDto toDto(PlayerStatus playerStatus);
    PlayerStatus toModel(PlayerStatusDto playerStatusDto);
}
