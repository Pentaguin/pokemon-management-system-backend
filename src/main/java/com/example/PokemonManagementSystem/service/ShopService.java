package com.example.PokemonManagementSystem.service;

import com.example.PokemonManagementSystem.exception.ShopNotFoundException;
import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop createShop() {
        return shopRepository.save(new Shop());
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public void deleteShopById(Long shopId){
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new ShopNotFoundException("Shop with id: " + shopId + " not found."));

        shopRepository.delete(shop);
    }

//    public void buyItems(Map<Long, Integer> itemsWithQuantities) {
//        // TODO something with shop id?
//        double totalCost = 0.0;
//
//        // Iterate over the map containing item IDs and their quantities
//        for (Map.Entry<Long, Integer> entry : itemsWithQuantities.entrySet()) {
//            Long itemId = entry.getKey();
//            Integer quantity = entry.getValue();
//
//            ShopItem shopItem = shopRepository.findShopItemById(itemId);
//
//            if (shopItem == null) {
//                throw new ItemNotFoundException("ShopItem not found for ID: " + itemId);
//            }
//
//            // Calculate total cost
//            totalCost += shopItem.getPrice() * quantity;
//        }
//
//        // Check if the player has enough gold
//        PlayerStatusDto playerStatusDto = playerStatusService.getStats();
//        if (playerStatusDto.getGold() < totalCost) {
//            throw new NotEnoughGoldException("Not enough gold to complete the purchase.");
//        }
//
//        // Deduct gold and update inventory
//        for (Map.Entry<Long, Integer> entry : itemsWithQuantities.entrySet()) {
//            Long itemId = entry.getKey();
//            Integer quantity = entry.getValue();
//
//            ShopItem shopItem = shopRepository.findShopItemById(itemId);
//            if (shopItem == null) {
//                throw new ItemNotFoundException("ShopItem not found for ID: " + itemId);
//            }
//
//            //TODO BAG UPDATE QUANTITY
//            // Update player's inventory, assuming a method exists to add items
//
//        }
//
//        // Deduct the total cost from player's gold
//        playerStatusDto.setGold(playerStatusDto.getGold() - totalCost);
//        playerStatusService.saveStats(playerStatusDto);
//    }
//
//
//    public void sellItem(Map<Long, Item> items){
//        // increase gold, and updating bag quantity
//    }

}
