package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.PlayerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatusRepository extends JpaRepository<PlayerStatus, Long> {
}
