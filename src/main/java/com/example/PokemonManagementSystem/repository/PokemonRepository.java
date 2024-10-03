package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
}
