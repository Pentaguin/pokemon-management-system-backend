package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.repository.ItemRepository;
import com.example.PokemonManagementSystem.web.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item addNewItem(Item item){
        // TODO if already exist. give itemAlreadyExistError
        return itemRepository.save(item);
    }

    public void updateItemDetails(){

    }

    public void getAllItems(){

    }

    public void getItemById(){

    }
}
