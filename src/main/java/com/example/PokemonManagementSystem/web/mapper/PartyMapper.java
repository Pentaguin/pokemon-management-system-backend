package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.model.Party;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartyMapper {

    PartyDto toDto(Party party);
    Party toModel(PartyDto partyDto);
}
