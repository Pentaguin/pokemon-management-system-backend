package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
}
