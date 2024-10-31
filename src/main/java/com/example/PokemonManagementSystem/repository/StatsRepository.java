package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Long> {
}
