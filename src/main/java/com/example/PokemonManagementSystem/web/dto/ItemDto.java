package com.example.PokemonManagementSystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Long itemApiId;
    private String itemName;
    private String description;
    private String imageUrl;
}