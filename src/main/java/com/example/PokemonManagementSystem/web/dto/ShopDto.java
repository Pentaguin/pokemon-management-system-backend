package com.example.PokemonManagementSystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
public class ShopDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private List<ShopItemDto> shopItems;
}