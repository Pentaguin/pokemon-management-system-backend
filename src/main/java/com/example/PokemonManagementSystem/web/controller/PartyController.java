package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.PartyService;
import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/party/pokemon")
public class PartyController {

    private final PartyService partyService;

    private PartyController(PartyService partyService){
        this.partyService = partyService;
    }

    @PostMapping
    public ResponseEntity<PartyDto> addPokemonToParty(@RequestBody PokemonDto pokemonDto) {
        PartyDto updatedParty = partyService.addPokemonToParty(pokemonDto);
        return new ResponseEntity<>(updatedParty, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PokemonDto>> getParty() {
        return partyService.getParty()
                .map(partyDto -> new ResponseEntity<>(partyDto.getPokemon(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK));
    }

    @DeleteMapping("{pokemonId}")
    public ResponseEntity<Void> deletePokemonFromParty(@PathVariable Long pokemonId) {
        Optional<PartyDto> party = partyService.getParty();

        if (party.isPresent()) {
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
