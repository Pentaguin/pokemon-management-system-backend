package com.example.PokemonManagementSystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ShopItemDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private ItemDto itemDto;
    private double price;
}