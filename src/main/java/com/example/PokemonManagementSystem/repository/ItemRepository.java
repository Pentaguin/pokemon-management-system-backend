package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
