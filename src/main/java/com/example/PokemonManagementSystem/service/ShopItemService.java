package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.exception.ItemNotFoundException;
import com.example.PokemonManagementSystem.exception.NotEnoughGoldException;
import com.example.PokemonManagementSystem.exception.ShopItemNotFoundException;
import com.example.PokemonManagementSystem.exception.ShopNotFoundException;
import com.example.PokemonManagementSystem.model.Item;
import com.example.PokemonManagementSystem.model.PlayerStatus;
import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.model.ShopItem;
import com.example.PokemonManagementSystem.repository.ItemRepository;
import com.example.PokemonManagementSystem.repository.ShopItemRepository;
import com.example.PokemonManagementSystem.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShopItemService {
    private final ShopRepository shopRepository;
    private final ShopItemRepository shopItemRepository;
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final PlayerStatusService playerStatusService;

    public List<ShopItem> getShopItemsByShopId(Long shopId) {
        Shop shop = getShop(shopId);
        return shop.getShopItems();
    }

    public ShopItem getShopItemByIdAndByShopId(Long shopId, Long shopItemId) {
        Shop shop = getShop(shopId);

        // Try to retrieve the shop item from the shop.
        return shop.getShopItems().stream()
                .filter(item -> item.getId().equals(shopItemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Shop item with id: " + shopItemId + " not found"));
    }

    public ShopItem createShopItem(Long shopId, ShopItem shopItem) {
        Shop shop = getShop(shopId);

        if (shopItem.getItem() == null) {
            throw new RuntimeException("Item details are missing in the request");
        }

        Item item = itemService.addNewItem(shopItem.getItem());
        shopItem.setItem(item);
        shopItem.setShop(shop);
        shopItemRepository.save(shopItem);
        return shopItem;
    }

    public void deleteShopItemById(Long shopId, Long shopItemId){
        Shop shop = getShop(shopId);

        ShopItem shopItemToRemove = shop.getShopItems().stream()
                .filter(shopItem -> shopItem.getId().equals(shopItemId))
                .findFirst()
                .orElseThrow(() ->new ShopItemNotFoundException("ShopItem with id: " + shopItemId + " not found."));

        shop.getShopItems().remove(shopItemToRemove);
        shopItemRepository.delete(shopItemToRemove);
    }

    public void updateShopItemById(Long shopId, Long shopItemId, ShopItem updatedShopItem){
        Shop shop = getShop(shopId);
        ShopItem shopItemToUpdate = shop.getShopItems().stream()
                .filter(shopItem -> shopItem.getId().equals(shopItemId))
                .findFirst()
                .orElseThrow(() ->new ShopItemNotFoundException("ShopItem with id: " + shopItemId + " not found."));

        // If a new Item is provided, ensure it is saved or already exists
        if (updatedShopItem.getItem() != null) {
            Item item = updatedShopItem.getItem();
            if (item.getId() == null) {
                // If the item is new, save it first
                item = itemRepository.save(item);
            }
            shopItemToUpdate.setItem(item);
        }

        shopItemToUpdate.setPrice(updatedShopItem.getPrice());
        shopItemRepository.save(shopItemToUpdate);
    }

    public void buyItems(Long shopId, Map<Long, Integer> itemsWithQuantities) {
        Shop shop = getShop(shopId);
        List<ShopItem> shopItems = shop.getShopItems();
        double totalCost = 0.0;

        for (Map.Entry<Long, Integer> entry : itemsWithQuantities.entrySet()) {
            Long itemId = entry.getKey();
            Integer quantity = entry.getValue();

            // Check if the item exists in the shop
            ShopItem shopItem = shopItems.stream()
                    .filter(item -> item.getId().equals(itemId))
                    .findFirst()
                    .orElseThrow(() -> new ItemNotFoundException("ShopItem with ID: " + itemId + " not found in Shop ID: " + shopId));

            // Calculate total cost
            totalCost += shopItem.getPrice() * quantity;
        }

        // Check if the player has enough gold
        PlayerStatus playerStatus = playerStatusService.getStats();
        if (playerStatus.getGold() < totalCost) {
            throw new NotEnoughGoldException("Not enough gold to complete the purchase.");
        }

        //TODO UPDATE PLAYER INVENTORY

        // Deduct the total cost from player's gold
        playerStatus.setGold(playerStatus.getGold() - totalCost);
        playerStatusService.saveStats(playerStatus);
    }

//    public void sellItem(Map<Long, Item> items){
    //TODO but not everything in your bag exists in that shop. some shop has it. some not.
//        // increase gold, and updating bag quantity
//    }

    private Shop getShop(Long shopId){
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop with id: " + shopId + " not found."));
    }
}