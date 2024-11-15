package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.web.dto.ShopDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ShopItemMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper {
    @Mapping(target = "shopItems", source = "shopItems")
    ShopDto toDto(Shop shop);
}
