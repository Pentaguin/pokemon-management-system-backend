package com.example.PokemonManagementSystem.repository;

import com.example.PokemonManagementSystem.model.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party,Long> {
}
