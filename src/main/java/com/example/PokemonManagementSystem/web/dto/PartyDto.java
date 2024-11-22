package com.example.PokemonManagementSystem.web.dto;

import lombok.Data;
import java.util.List;

@Data
public class PartyDto {
    private List<PokemonDto> pokemon;
}