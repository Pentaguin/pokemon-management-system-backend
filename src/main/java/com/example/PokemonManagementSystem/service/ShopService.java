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
}