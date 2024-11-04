package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ShopItemMapper.class)
public interface ShopMapper {
    @Mapping(target = "shopItems", source = "shopItems")
    ShopDto toDto(Shop shop);
}
