package com.example.PokemonManagementSystem.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {
    private Long id;
    private List<ShopItemDto> shopItems;
}
