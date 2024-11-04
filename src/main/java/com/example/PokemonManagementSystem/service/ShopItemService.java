package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.repository.ShopItemRepository;
import com.example.PokemonManagementSystem.repository.ShopRepository;
import com.example.PokemonManagementSystem.utl.ColorLogger;
import com.example.PokemonManagementSystem.web.dto.ItemDto;
import com.example.PokemonManagementSystem.web.dto.ShopItemDto;
import com.example.PokemonManagementSystem.web.mapper.ItemMapper;
import com.example.PokemonManagementSystem.web.mapper.ShopItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopItemService {


    private final ShopItemMapper shopItemMapper;
    private final ShopRepository shopRepository;
    private final ShopItemRepository shopItemRepository;
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    private ShopItemService(ShopItemMapper shopItemMapper, ShopRepository shopRepository, ShopItemRepository shopItemRepository, ItemService itemService, ItemMapper itemMapper){
        this.shopItemMapper = shopItemMapper;
        this.shopRepository = shopRepository;
        this.shopItemRepository = shopItemRepository;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    public List<ShopItemDto> getShopItemsByShopId(Long shopId) {
        // TODO throw ShopNotFoundException
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        return shop.getShopItems().stream()
                .map(shopItemMapper::toDto)
                .collect(Collectors.toList());
    }

    public ShopItemDto createShopItem(Long shopId, ShopItemDto shopItemDto) {
        // Retrieve the shop, throwing an exception if not found
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        // Ensure itemDto is not null and has a valid ID
        if (shopItemDto.getItemDto() == null) {
            throw new RuntimeException("Item details are missing in the request");
        }

        // Create a new ShopItem and set its properties
        ShopItem shopItem = new ShopItem();
        shopItem.setPrice(shopItemDto.getPrice());
        ItemDto itemDto = itemService.addNewItem(shopItemDto.getItemDto());
        shopItem.setItem(itemMapper.toModel(itemDto));
        shopItem.setShop(shop);

        shopItemRepository.save(shopItem);
        shop.getShopItems().add(shopItem);
        shopRepository.save(shop);
        return shopItemMapper.toDto(shopItem);
    }

    // TODO DELETE SHOP

}