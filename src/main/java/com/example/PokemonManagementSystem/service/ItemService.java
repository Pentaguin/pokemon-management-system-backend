package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.repository.ItemRepository;
import com.example.PokemonManagementSystem.utl.ColorLogger;
import com.example.PokemonManagementSystem.web.dto.ItemDto;
import com.example.PokemonManagementSystem.web.mapper.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    private ItemService(ItemRepository itemRepository, ItemMapper itemMapper){
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

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
