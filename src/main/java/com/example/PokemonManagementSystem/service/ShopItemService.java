package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.exception.ItemNotFoundException;
import com.example.PokemonManagementSystem.exception.ShopNotFoundException;
import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.repository.ShopItemRepository;
import com.example.PokemonManagementSystem.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopItemService {
    private final ShopRepository shopRepository;
    private final ShopItemRepository shopItemRepository;
    private final ItemService itemService;

    public List<ShopItem> getShopItemsByShopId(Long shopId) {
        // Try to retrieve the shop.
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop with id: " + shopId + " not found."));

        // Get all the items from the shop.
        return shop.getShopItems();
    }

    public ShopItem getShopItemByIdAndByShopId(Long shopId, Long shopItemId) {
        // Try to retrieve the shop
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop with id: " + shopId + " not found."));

        // Try to retrieve the shop item from the shop.
        return shop.getShopItems().stream()
                .filter(item -> item.getId().equals(shopItemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Shop item with id: " + shopItemId + " not found"));
    }

    public ShopItem createShopItem(Long shopId, ShopItem shopItem) {
        // Retrieve the shop or throw an exception if not found
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop with id: " + shopId + " not found."));

        // Ensure the item is not null
        if (shopItem.getItem() == null) {
            throw new RuntimeException("Item details are missing in the request");
        }

        Item item = itemService.addNewItem(shopItem.getItem());
        shopItem.setItem(item);
        shopItem.setShop(shop);
        shopItemRepository.save(shopItem);
        return shopItem;
    }

    // TODO DELETE SHOPITEM

}
