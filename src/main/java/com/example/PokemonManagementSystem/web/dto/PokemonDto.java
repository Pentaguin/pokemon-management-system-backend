package com.example.PokemonManagementSystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PokemonDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Integer pokeApiId;
    private String name;
    private String imageUrl;
    private String type;
    private Integer generation;
}
