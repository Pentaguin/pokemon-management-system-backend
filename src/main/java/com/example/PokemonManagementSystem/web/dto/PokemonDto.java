package com.example.PokemonManagementSystem.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDto {
    private Integer pokeApiId;
    private String name;
    private String imageUrl;
    private String type;
    private Integer generation;
}
