package com.example.PokemonManagementSystem.web.transformer;

import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.model.Party;
import com.example.PokemonManagementSystem.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartyTransformer {
    public static PartyDto toDto(Party party) {
        PartyDto dto = new PartyDto();

        dto.setTeamLimit(party.getPartyLimit());
        dto.setPokemons(party.getPokemons().stream()
                .map(PokemonTransformer::toDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public static Party toModel(PartyDto partyDto) {
        Party party = new Party();
        party.setPartyLimit(partyDto.getTeamLimit());

        List<Pokemon> pokemons = partyDto.getPokemons().stream()
                .map(PokemonTransformer::toModel)
                .collect(Collectors.toList());

        party.setPokemons(pokemons);
        return party;
    }
}