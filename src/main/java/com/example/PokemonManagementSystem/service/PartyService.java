package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Party;
import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.repository.PartyRepository;
import com.example.PokemonManagementSystem.repository.PokemonRepository;
import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import com.example.PokemonManagementSystem.web.transformer.PartyTransformer;
import com.example.PokemonManagementSystem.web.transformer.PokemonTransformer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PartyService {
    private final PartyRepository partyRepository;
    private final PokemonRepository pokemonRepository;

    private PartyService(PartyRepository partyRepository, PokemonRepository pokemonRepository){
        this.partyRepository = partyRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public PartyDto addPokemonToParty(PokemonDto pokemonDto) {
        Party party = partyRepository.findById(1L)
                .orElseGet(() -> {
                    Party newParty = new Party();
                    newParty.setPartyLimit(6);
                    return partyRepository.save(newParty);
                });
        Pokemon pokemon = PokemonTransformer.toModel(pokemonDto);

        // TODO if party limit is already 6. Throw PartyIsFullException.

        // Add Pokemon to the party
        party.getPokemons().add(pokemon);
        pokemon.setParty(party);
        partyRepository.save(party);
        return PartyTransformer.toDto(party);
    }

    public Optional<PartyDto> getParty() {
        return partyRepository.findById(1L)
                .map(PartyTransformer::toDto);
    }


}
