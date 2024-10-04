package com.example.PokemonManagementSystem.web.dto;

import com.example.PokemonManagementSystem.model.Pokemon;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PartyDto {
    private Integer teamLimit;
    private List<PokemonDto> pokemons;

}
