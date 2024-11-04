package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Shop;
import com.example.PokemonManagementSystem.model.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    ShopItem findShopItemById(Long Id); // Example method
}