package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.model.Party;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartyMapper {
    PartyDto toDto(Party party);
    Party toModel(PartyDto partyDto);
}
