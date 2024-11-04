package com.example.PokemonManagementSystem.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    @JsonIgnore
    private Long id;
    private Long itemApiId;
    private String itemName;
    private String description;
    private String imageUrl;
}
