package com.example.PokemonManagementSystem.web.controller;

import com.example.PokemonManagementSystem.service.PartyService;
import com.example.PokemonManagementSystem.web.dto.PartyDto;
import com.example.PokemonManagementSystem.web.dto.PokemonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    private final PartyService partyService;

    private PartyController(PartyService partyService){
        this.partyService = partyService;
    }

    @PostMapping("/add-pokemon")
    public ResponseEntity<PartyDto> addPokemonToParty(@RequestBody PokemonDto pokemonDto) {
        PartyDto updatedParty = partyService.addPokemonToParty(pokemonDto);
        return new ResponseEntity<>(updatedParty, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PartyDto>> getParty() {
        return partyService.getParty()
                .map(partyDto -> new ResponseEntity<>(List.of(partyDto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK));
    }

}
