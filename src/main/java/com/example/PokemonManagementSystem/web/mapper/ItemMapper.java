package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.web.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toModel(ItemDto itemDto);
}