package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface ShopItemMapper {
    @Mapping(source = "item", target = "itemDto")
    ShopItemDto toDto(ShopItem shopItem);

    ShopItem toModel(ShopItemDto shopItemDto);
}