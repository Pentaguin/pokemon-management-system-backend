package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.model.Party;
import com.example.PokemonManagementSystem.service.PartyService;
import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import com.example.PokemonManagementSystem.web.mapper.PartyMapper;
import com.example.PokemonManagementSystem.web.mapper.PokemonMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/party/pokemon")
@RequiredArgsConstructor
@Tag(name = "/party", description = "Operations on Party")
public class PartyController {
    private final PartyService partyService;
    private final PartyMapper partyMapper;
    private final PokemonMapper pokemonMapper;

    @PostMapping
    public ResponseEntity<PartyDto> addPokemonToParty(@RequestBody PokemonDto pokemonDto) {
        PartyDto updatedParty = partyMapper.toDto(partyService.addPokemonToParty(pokemonMapper.toModel(pokemonDto)));
        return new ResponseEntity<>(updatedParty, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PokemonDto>> getParty() {
        Party party = partyService.getParty();

        if (party != null && !party.getPokemon().isEmpty()) {
            List<PokemonDto> pokemonDtos = pokemonMapper.toDtoList(party.getPokemon());
            return new ResponseEntity<>(pokemonDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
    }

    @DeleteMapping("{pokemonId}")
    public ResponseEntity<Void> deletePokemonFromParty(@PathVariable Long pokemonId) {
        Party party = partyService.getParty();

        if (party != null) {
            boolean removed = partyService.deletePokemonFromParty(pokemonId);
            if (removed) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}