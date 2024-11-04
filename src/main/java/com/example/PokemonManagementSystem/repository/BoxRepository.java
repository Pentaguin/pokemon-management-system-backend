package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Box;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends CrudRepository<Box,Long> {
}
