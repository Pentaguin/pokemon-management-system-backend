package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.exception.PartyIsFullException;
import com.example.PokemonManagementSystem.exception.PokemonNotFoundException;
import com.example.PokemonManagementSystem.model.Party;
import com.example.PokemonManagementSystem.model.Pokemon;
import com.example.PokemonManagementSystem.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    public Party addPokemonToParty(Pokemon pokemon) {
        Party party = partyRepository.findById(1L)
                .orElseGet(() -> {
                    Party newParty = new Party();
                    newParty.setPartyLimit(6);
                    return partyRepository.save(newParty);
                });

        // Party is full
        if(party.getPokemon().size() >= party.getPartyLimit()){
            throw new PartyIsFullException(String.format("Party is full. Only %d pokemon allowed.", party.getPartyLimit()));
        }

        // Add Pokemon to the party
        party.getPokemon().add(pokemon);
        pokemon.setParty(party);
        partyRepository.save(party);
        return party;
    }

    public Party getParty() {
        return partyRepository.findById(1L).orElseGet(() -> {
            Party emptyParty = new Party();
            emptyParty.setPokemon(Collections.emptyList());
            return emptyParty;
        });
    }

    public boolean deletePokemonFromParty(Long pokemonId) {
        Optional<Party> optionalParty = partyRepository.findById(1L);

        if (optionalParty.isPresent()) {
            Party party = optionalParty.get();
            boolean removed = party.getPokemon().removeIf(pokemon -> pokemon.getId().equals(pokemonId));

            if (removed) {
                partyRepository.save(party);
                return true;
            } else {
                throw new PokemonNotFoundException("Pokemon not found");
            }
        }
        // TODO throw new PartyNotFoundException
        return false;
    }


}
