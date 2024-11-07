package com.example.PokemonManagementSystem.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopItemDto {
    private Long id;
    private ItemDto itemDto;
    private double price;
}
