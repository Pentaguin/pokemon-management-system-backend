package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ItemMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopItemMapper {
    @Mapping(source = "item", target = "itemDto")
    ShopItemDto toDto(ShopItem shopItem);

    @Mapping(source = "itemDto", target = "item")
    ShopItem toModel(ShopItemDto shopItemDto);
}