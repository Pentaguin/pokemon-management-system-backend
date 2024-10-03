package com.example.PokemonManagementSystem.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDto {
    private Long id;
    private Integer pokeApiId;
    private String name;
    private String imageUrl;
    private String type;
    private Integer generation;

    private Long boxId;
    private Long teamId;
}
