package com.example.PokemonManagementSystem.web.mapper;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.web.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toModel(ItemDto itemDto);
}