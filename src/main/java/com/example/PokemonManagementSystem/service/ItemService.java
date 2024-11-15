package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.repository.ItemRepository;
import com.example.PokemonManagementSystem.web.dto.ItemDto;
import com.example.PokemonManagementSystem.web.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemDto addNewItem(ItemDto itemDto){
        // TODO if already exist. give itemAlreadyExistError
        Item item = itemMapper.toModel(itemDto);
        return itemMapper.toDto(itemRepository.save(item));
    }

    public void updateItemDetails(){

    }

    public void getAllItems(){

    }

    public void getItemById(){

    }
}
